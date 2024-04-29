package com.utoppia.stockapi.service;

import com.utoppia.stockapi.entity.QuoteResponse;
import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.persistance.StockDataRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FinnHubService {

    @Value("${finnhub.symbol}")
    private String finnHubSymbol;

    @Value("${finnhub.token}")
    private String finnHubToken;


    @Autowired
    private  WebClient finnHubWebClient;

    @Autowired
    private StockDataRepository stockDataRepository;

    @Autowired
    private ModelMapper mapper;

    private static Logger logger = LoggerFactory.getLogger(FinnHubService.class);
    /**
     * Get stock quote
     * @param symbol
     * @return
     */
    public QuoteResponse getStockQuote(final String symbol){

        return finnHubWebClient
                .get()

                .uri(uriBuilder -> uriBuilder
                        .queryParam("symbol", String.format(finnHubSymbol, symbol))
                        .queryParam("token", finnHubToken)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<QuoteResponse>() {})
                .block();
    }

    /**
     * update stock quote with FinnHub Data
     * @param symbol
     *
     */
    public void updateStockDataWithFinnHubQuote(final String symbol){

        QuoteResponse response =  this.getStockQuote(symbol);
        logger.debug(response.toString());

        //When symbol not found, Finnhub return all json's field with null or zeroes
        if(Double.compare(response.getCurrentPrice(), 0) == 0 && response.getTimestamp() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        StockData stockData = mapper.map(response, StockData.class);
        stockData.setSymbol(symbol);

        logger.debug(stockData.toString());

        stockDataRepository.save(stockData);

    }

}
