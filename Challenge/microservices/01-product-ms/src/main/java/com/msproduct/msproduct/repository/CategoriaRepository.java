package com.msproduct.msproduct.repository;

import com.msproduct.msproduct.model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Query(value = "SELECT c FROM Categoria c")
    public List<Categoria> obtenerTodos();
}
