package com.utoppia.stockapi;


import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.persistance.StockDataRepository;
import com.utoppia.stockapi.service.StockDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class for testing stockDataService
 * @author cesarflores
 *
 */
@ExtendWith(MockitoExtension.class)
public class StockDataServiceTest {

    @Mock
    StockDataRepository stockDataRepository;


    @InjectMocks
    StockDataService stockDataService;

    @Test
    void getStockData_success() throws Exception {

        List<StockData> stockDataList = createStockList();

        Mockito.when(stockDataRepository.findTop10BySymbolOrderByStockDataIdDesc("AAPL")).thenReturn(stockDataList);

        assertEquals(stockDataService.getStockDataForSymbol("AAPL").size(), 2);
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getSymbol(), "AAPL");
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getStockDataId(), 3);
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getCurrentPrice(), 13.3);
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getPreviousClosePrice(), 12.5);
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getChange(), 0.5);
        assertEquals(stockDataService.getStockDataForSymbol("AAPL").getFirst().getPercentChange(), 0.6);

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
