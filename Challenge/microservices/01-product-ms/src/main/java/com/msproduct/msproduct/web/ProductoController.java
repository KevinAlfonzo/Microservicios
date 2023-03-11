package com.msproduct.msproduct.web;

import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.service.ProductoService;
import com.msproduct.msproduct.web.mapper.ProductoMapper;
import com.msproduct.msproduct.web.message.ProductoMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-product/v1/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    public ProductoController(ProductoService productoService, ProductoMapper productoMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    /**
     * Consultar productos que sean validos
     *
     * @param ids Identificadores de los productos
     * @return 200 si existe datos con los ids enviados.
     */
    @GetMapping("/validos")
    public List<Producto> obtenerPorIds(@RequestBody List<Long> ids) {
        return productoService.buscarPorIds(ids);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Producto crear(@RequestBody ProductoMessage message) {
        Producto producto = productoMapper.toProducto(message);
        return productoService.crear(producto);
    }

    @PutMapping("/{productoId}")
    public Producto actualizar(@PathVariable Long productoId, @RequestBody ProductoMessage message) {
        Producto producto = productoMapper.toProducto(message);
        return productoService.actualizar(productoId, producto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{productoId}")
    public void eliminar(@PathVariable Long productoId) {
        productoService.eliminar(productoId);
    }

    @GetMapping("/test/{id}")
    public Producto BuscarId(@PathVariable Long id) {
        return productoService.finbyId(id);
    }
}
