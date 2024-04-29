package com.utoppia.stockapi.service;

import com.utoppia.stockapi.entity.StockData;
import com.utoppia.stockapi.entity.dto.StockDataDto;
import com.utoppia.stockapi.persistance.StockDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Stock service class
 *
 */
@Service
public class StockDataService {

    @Autowired
    private StockDataRepository stockDataRepository;

    public List<StockDataDto> getStockDataForSymbol(String symbol) {


        List<StockData> stockDataList = stockDataRepository.findTop10BySymbolOrderByStockDataIdDesc(symbol);

       /* List<GCuentaBancariaExterior> cuentasExt = cuentaExteriorRepository
                .buscarCuentasBancariasExteriorPorPersona(tipoDocumento, numeroDocumento);

        */

        ModelMapper modelMapper = new ModelMapper();

        return stockDataList.stream()
                .map(entity -> modelMapper.map(entity, StockDataDto.class))
                .collect(Collectors.toList());
    }


}
