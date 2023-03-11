package com.msproduct.msproduct.web.message;

import java.math.BigDecimal;

public class ProductoMessage {
    private final Long categoria_id;
    private final String sku;
    private final String nombre;
    private final String descripcion;
    private final Double precioVenta;
    private final Integer stock;
    private final boolean estado;

    public ProductoMessage(Long categoria_id, String sku, String nombre, String descripcion, Double precioVenta, Integer stock, boolean estado) {
        this.categoria_id = categoria_id;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.estado = estado;
    }

    public Long getCategoriaId() {
        return categoria_id;
    }

    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Integer getStock() {
        return stock;
    }

    public boolean isEstado() {
        return estado;
    }
}
