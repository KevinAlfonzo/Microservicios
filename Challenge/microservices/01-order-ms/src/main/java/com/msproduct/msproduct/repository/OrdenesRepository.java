package com.msproduct.msproduct.repository;

import com.msproduct.msproduct.model.Ordenes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenesRepository extends CrudRepository<Ordenes, Long> {

    //@Query(value = "SELECT o FROM Ordenes o WHERE o.id IN :ids")
    //List<Producto> buscarPorIds(@Param("ids") List<Long> ids);
}
