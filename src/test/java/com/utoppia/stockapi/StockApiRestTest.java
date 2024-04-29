package com.utoppia.stockapi;


import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.entity.dto.StockDataDto;
import com.utoppia.stockapi.rest.StockController;
import com.utoppia.stockapi.service.FinnHubService;
import com.utoppia.stockapi.service.StockDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class for integration test in stock-api
 * @author cesarflores
 *
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebMvcTest(StockController.class)
@AutoConfigureMockMvc(addFilters = false)
public class StockApiRestTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StockDataService stockDataService;

    @MockBean
    FinnHubService finnHubService;


    @Test
    void getStockData_success() throws Exception {

        List<StockDataDto> stockDataDtoList = createDtoList();
        Mockito.when(stockDataService.getStockDataForSymbol("AAPL")).thenReturn(stockDataDtoList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/stock?symbol=AAPL")
                .contentType(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isOk()) ;

    }

    @Test
    void getStockDataSymbolFieldEmpty_badRequest() throws Exception {

        Mockito.when(stockDataService.getStockDataForSymbol("")).thenReturn(new ArrayList<StockDataDto>());

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/stock?symbol=")
                .contentType(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isBadRequest()) ;

    }

    @Test
    void updateStockData_success() throws Exception {

       // List<StockDataDto> stockDataDtoList = createDtoList();
        Mockito.doNothing().when(finnHubService).updateStockDataWithFinnHubQuote("AAPL");

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/stock?symbol=AAPL")
                .contentType(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isOk()) ;

    }

    @Test
    void updateStockDataNotValidSymbol_NotFound() throws Exception {

        Mockito.doThrow(new ResponseStatusException((HttpStatus.NOT_FOUND)))
                .when(finnHubService).updateStockDataWithFinnHubQuote("NOTEXIST");

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/stock?symbol=NOTEXIST")
                .contentType(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isNotFound()) ;

    }

    private List<StockDataDto> createDtoList() {

        StockDataDto stockOne = new StockDataDto();
        stockOne.setSymbol("AAPL");
        stockOne.setStockDataId(3);
        stockOne.setCurrentPrice(13.3);
        stockOne.setPreviousClosePrice(12.5);
        stockOne.setChange(0.5);
        stockOne.setPercentChange(0.6);

        StockDataDto stockTwo = new StockDataDto();
        stockTwo.setSymbol("AAPL");
        stockTwo.setStockDataId(2);
        stockTwo.setCurrentPrice(12.1);
        stockTwo.setPreviousClosePrice(11.5);
        stockTwo.setChange(0.9);
        stockTwo.setPercentChange(0.6);

        return List.of(stockOne, stockTwo);



    }


}
