package com.utoppia.stockapi.rest;


import com.utoppia.stockapi.entity.dto.StockDataDto;
import com.utoppia.stockapi.service.FinnHubService;
import com.utoppia.stockapi.service.StockDataService;
import io.swagger.v3.oas.annotations.Operation;
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
    public ResponseEntity<Void/*List<StockDataDto>*/> getStockData(
            @RequestParam String symbol) {

        //return ResponseEntity.ok(stockDataService.vacio(symbol);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update stock Data")
    @PostMapping()
    public ResponseEntity<Void> updateStockData(
            @RequestParam String symbol) {

        finnHubService.updateStockDataWithFinnHubQuote(symbol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
