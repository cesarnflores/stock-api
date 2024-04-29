package com.utoppia.stockapi.service;

import com.utoppia.stockapi.entity.dto.StockDataDto;
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

 /*   @Autowired
    private CuentaRepository cuentaRepository;
*/
  /*  public List<StockDataDto> obtenerCuentasBancariasExterior(String symmbol) {

        List<GCuentaBancariaExterior> cuentasExt = cuentaExteriorRepository
                .buscarCuentasBancariasExteriorPorPersona(tipoDocumento, numeroDocumento);
        ModelMapper modelMapper = new ModelMapper();

        return cuentasExt.stream()
                .map(entity -> modelMapper.map(entity, GCuentaBancariaExteriorDTO.class))
                .collect(Collectors.toList());
    }*/

    public void vacio(String symmbol){}


}
