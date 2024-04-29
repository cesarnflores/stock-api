package com.utoppia.stockapi.persistance;

import com.utoppia.stockapi.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository class for StockData entity
 */

@Repository
public interface StockDataRepository extends JpaRepository<StockData, Integer> {
        List<StockData> findTop10BySymbolOrderByStockDataIdDesc(String symbol);

}
