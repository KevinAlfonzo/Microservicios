package com.msproduct.msproduct.web;

import com.msproduct.msproduct.model.Ordenes;
import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.service.OrdenesService;
import com.msproduct.msproduct.web.mapper.OrdenesMapper;
import com.msproduct.msproduct.web.message.OrdenesMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/ms-order/v1/ordenes")
public class OrdenesController {

    private final OrdenesService ordenesService;

    private final OrdenesMapper ordenesMapper;

    public OrdenesController(OrdenesService ordenesService, OrdenesMapper ordenesMapper){
        this.ordenesService = ordenesService;
        this.ordenesMapper = ordenesMapper;
    };

    @GetMapping
    public List<Ordenes> listar(){
        return ordenesService.obtenerTodos();
    }

    @PostMapping
    public Ordenes test(@RequestBody OrdenesMessage message){

        Ordenes ordenes = ordenesMapper.crearTest(message);

        return ordenesService.crear(ordenes);
    }


    @GetMapping("/search/{id}")
    public Ordenes ordenesId(@PathVariable Long id){
        return ordenesService.ordenesId(id);
    }
}
