package com.utoppia.stockapi.persistance;

import com.utoppia.stockapi.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository class for StockData entity
 */

@Repository
public interface StockDataRepository extends JpaRepository<StockData, Integer> {


        /*Optional<Item> findById(Integer idItem);

        List<Item> findAll();

        @Query(value = "SELECT * FROM item i LEFT JOIN item_facturacion ifac "
                + " ON i.id_item_facturacion  = ifac.item_facturacion_id  " + " WHERE "
                + " (i.descripcion LIKE %?1% or i.descripcion is null) and "
                + " IF(ISNULL(?2), 1=1, i.admite_imputacion = ?2 ) and  "
                + " (ifac.codigo_articulo LIKE %?3% or ifac.codigo_articulo is null) and "
                + " (i.activo = ?4 or ?4 is null)", nativeQuery = true)
        List<Item> findByDescImpCodArtActivo(String descripcion, Boolean imputable, String codigoArticulo, Boolean activo);
*/
}
