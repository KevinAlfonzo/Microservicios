package com.msproduct.msproduct.service;

import com.msproduct.msproduct.model.Categoria;
import com.msproduct.msproduct.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto crear(Producto producto);
    Producto actualizar(Long id, Producto producto);
    List<Producto> obtenerTodos();
    void eliminar(Long id);
    List<Producto> buscarPorIds(List<Long> ids);

    Producto finbyId(Long id);

}
