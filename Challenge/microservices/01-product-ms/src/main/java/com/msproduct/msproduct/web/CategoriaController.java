package com.msproduct.msproduct.web;

import com.msproduct.msproduct.model.Categoria;
import com.msproduct.msproduct.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-product/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> obtenerTodos(){
        return categoriaService.listarTodos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.crear(categoria);
    }

    @PutMapping("/{categoriaId}")
    public Categoria actualizar(@PathVariable Long categoriaId, @RequestBody Categoria categoria) {
        return categoriaService.actualizar(categoriaId, categoria);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{categoriaId}")
    public void eliminar(@PathVariable Long categoriaId) {
        categoriaService.eliminar(categoriaId);
    }

}
