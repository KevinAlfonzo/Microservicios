package com.msproduct.msproduct.service;

import com.msproduct.msproduct.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria crear(Categoria categoria);

    Categoria actualizar(Long id, Categoria categoria);

    List<Categoria> listarTodos();

    Optional<Categoria> buscarPorId(Long id);

    void eliminar(Long id);
}
