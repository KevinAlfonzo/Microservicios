package com.msproduct.msproduct.web.message;

import java.math.BigDecimal;

public class OrdenesMessage {


    private final Long producto_id;
    private final Long cantidad;




    public OrdenesMessage(Long producto_id, Long cantidad) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;

    }

    public Long getProducto_id() {
        return producto_id;
    }

    public Long getCantidad() {
        return cantidad;
    }



}
