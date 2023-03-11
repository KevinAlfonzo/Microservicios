package com.msproduct.msproduct.service;



import com.msproduct.msproduct.model.Ordenes;
import com.msproduct.msproduct.model.Producto;

import java.util.List;
import java.util.Optional;

public interface OrdenesService {

    Ordenes crear(Ordenes ordenes);
    Ordenes actualizar(Long id, Ordenes ordenes);
    List<Ordenes> obtenerTodos();
    void eliminar(Long id);
    List<Ordenes> buscarPorIds(List<Long> ids);

    Optional<Producto> validarPRoduct(Long id);

    Ordenes ordenesId(Long id);
}
