package com.utoppia.stockapi.service;

import com.utoppia.stockapi.entity.QuoteResponse;
import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.persistance.StockDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
        System.out.println(response);

        StockData stockData = mapper.map(response, StockData.class);
        stockData.setSymbol(symbol);

        System.out.println(stockData);

        stockDataRepository.save(stockData);

        //updateDataBase



    }
  /*  public Mono<Details> someRestCall(String name) {
        return this.webClient.get().url("/{name}/details", name)
                .retrieve().bodyToMono(Details.class);
    }
*/

}
