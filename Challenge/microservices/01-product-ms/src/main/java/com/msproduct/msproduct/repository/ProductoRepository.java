package com.msproduct.msproduct.repository;

import com.msproduct.msproduct.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query(value = "SELECT p FROM Producto p WHERE p.id IN :ids")
    List<Producto> buscarPorIds(@Param("ids") List<Long> ids);
}
