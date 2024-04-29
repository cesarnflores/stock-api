package com.utoppia.stockapi.rest;


import com.utoppia.stockapi.entity.dto.StockDataDto;
import com.utoppia.stockapi.service.FinnHubService;
import com.utoppia.stockapi.service.StockDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Stock Controller
 * @author cesarflores
 */

@RestController
@RequestMapping("v1/stock")
public class StockController {

    @Autowired
    private StockDataService stockDataService;

    @Autowired
    private FinnHubService finnHubService;


    @Operation(summary = "Retrieve stock data")
    @GetMapping()
    public ResponseEntity<List<StockDataDto>> getStockData(
            @RequestParam(required = true) String symbol ) {

        return ResponseEntity.ok(stockDataService.getStockDataForSymbol(symbol));
    }

    @Operation(summary = "Update stock Data")
    @PostMapping()
    public ResponseEntity<Void> updateStockData(
            @RequestParam(required = true) String symbol) {

        finnHubService.updateStockDataWithFinnHubQuote(symbol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
