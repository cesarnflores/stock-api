package com.utoppia.stockapi;


import com.utoppia.stockapi.entity.QuoteResponse;
import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.persistance.StockDataRepository;
import com.utoppia.stockapi.service.FinnHubService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for testing FinnHubService
 * Disabled. Needs to be completed
 * @author cesarflores
 *
 */
@ExtendWith(MockitoExtension.class)
@Disabled
public class FinnHubServiceTest {

    @Mock
    StockDataRepository stockDataRepository;

    @Mock
    WebClient finnHubWebClient;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    FinnHubService finnHubService;



    @Test
    void getStockDataFromFinnHub_success() throws Exception {

        Mockito.doNothing().when(finnHubWebClient).get();
        Mockito.when(finnHubService.getStockQuote("NOTEXIST")).thenReturn(this.getEmptyStockQuote());


        assertThrows(ResponseStatusException.class, () ->finnHubService.updateStockDataWithFinnHubQuote("NOTEXIST"));
    }


    private QuoteResponse getStockQuote() {
        QuoteResponse resp = new QuoteResponse();
        resp.setChange(0.5);
        resp.setCurrentPrice(13.3);
        resp.setHighPrice(13.4);
        resp.setTimestamp(123456874);
        resp.setLowPrice(12.8);

        return resp;
    }

    private QuoteResponse getEmptyStockQuote() {
        QuoteResponse resp = new QuoteResponse();
        resp.setChange(0);
        resp.setCurrentPrice(0);
        resp.setHighPrice(0);
        resp.setTimestamp(0);
        resp.setLowPrice(0);

        return resp;
    }


    private List<StockData> createStockList() {
        StockData stockOne = new StockData();
        stockOne.setSymbol("AAPL");
        stockOne.setStockDataId(3);
        stockOne.setCurrentPrice(13.3);
        stockOne.setPreviousClosePrice(12.5);
        stockOne.setChange(0.5);
        stockOne.setPercentChange(0.6);

        StockData stockTwo = new StockData();
        stockTwo.setSymbol("AAPL");
        stockTwo.setStockDataId(2);
        stockTwo.setCurrentPrice(12.1);
        stockTwo.setPreviousClosePrice(11.5);
        stockTwo.setChange(0.9);
        stockTwo.setPercentChange(0.6);

        return List.of(stockOne, stockTwo);

    }

}
