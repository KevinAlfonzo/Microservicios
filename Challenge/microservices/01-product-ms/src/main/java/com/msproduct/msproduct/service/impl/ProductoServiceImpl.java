package com.msproduct.msproduct.service.impl;

import com.msproduct.msproduct.exception.NotFoundException;
import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.repository.ProductoRepository;
import com.msproduct.msproduct.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {
        return productoRepository.findById(id)
                .map(productoEncontrado -> {
                    producto.setId(productoEncontrado.getId());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new NotFoundException("Para el producto : " + id));
    }

    @Override
    public List<Producto> obtenerTodos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Para el producto : " + id));
        productoRepository.delete(producto);
    }

    @Override
    public List<Producto> buscarPorIds(List<Long> ids) {
        return productoRepository.buscarPorIds(ids);
    }


    @Override
    public Producto finbyId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Numero de ID no encontrado:  " + id));
    }

}
