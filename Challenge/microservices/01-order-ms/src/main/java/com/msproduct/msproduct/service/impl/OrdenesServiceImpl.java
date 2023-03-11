package com.msproduct.msproduct.service.impl;

import com.msproduct.msproduct.exception.NotFoundException;
import com.msproduct.msproduct.model.Ordenes;
import com.msproduct.msproduct.model.Producto;
import com.msproduct.msproduct.repository.OrdenesRepository;
import com.msproduct.msproduct.service.OrdenesService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


@Service
public class OrdenesServiceImpl implements OrdenesService {

    private final OrdenesRepository ordenesRepository;

    public OrdenesServiceImpl(OrdenesRepository ordenesRepository){
        this.ordenesRepository = ordenesRepository;
    }

    @Override
    public Ordenes crear(Ordenes ordenes) {

        return ordenesRepository.save(ordenes);
    }

    public Optional<Producto> validarPRoduct(Long id){
        WebClient webClient = WebClient.create("http://localhost:8080/ms-product/v1/productos/test/" + id);
        ClientResponse response = webClient.get().exchange().block();

        Producto UnicProduct= webClient.get()
                                    .retrieve()
                                    .bodyToMono(Producto.class)
                                    .block();


        return Optional.ofNullable(UnicProduct);
    }

    @Override
    public Ordenes ordenesId(Long id) {
        return ordenesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Numero de ID no encontrado:  " + id));
    }

    @Override
    public Ordenes actualizar(Long id, Ordenes ordenes) {
        return null;
    }

    @Override
    public List<Ordenes> obtenerTodos() {
        return (List<Ordenes>) ordenesRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Ordenes> buscarPorIds(List<Long> ids) {
        return null;
    }
}
