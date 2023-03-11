package com.msproduct.msproduct.web.mapper;

import com.msproduct.msproduct.exception.BadRequestException;
import com.msproduct.msproduct.model.Categoria;
import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.service.CategoriaService;
import com.msproduct.msproduct.web.message.ProductoMessage;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    private final CategoriaService categoriaService;

    public ProductoMapper(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public Producto toProducto(ProductoMessage message) {
        Categoria categoria = categoriaService.buscarPorId(message.getCategoriaId())
                .orElseThrow(() -> new BadRequestException("La categoria es incorrecta"));
        return new Producto(categoria, message.getSku(), message.getNombre(), message.getDescripcion(),message.getPrecioVenta(), message.getStock() , true);
    }

}
