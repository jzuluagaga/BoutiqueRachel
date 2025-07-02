package com.boutique.rachel.boutique_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedId")
    private Integer pedId;

    @Column(name = "pedFecha", nullable = false)
    private LocalDateTime pedFecha = LocalDateTime.now();

    @Column(name = "pedEstado", nullable = false, length = 20)
    private String pedEstado = "PENDIENTE";

    @Column(name = "pedTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal pedTotal;

    @Column(name = "pedDireccionEntrega", nullable = false, length = 100)
    private String pedDireccionEntrega;

    @Column(name = "pedMetodoEnvio", nullable = false, length = 45)
    private String pedMetodoEnvio;

    @Column(name = "CLIENTE_USUARIO_usuId", nullable = false)
    private Integer clienteUsuarioUsuId;

    @Column(name = "FACTURA_facId", nullable = false)
    private Integer facturaFacId;

    public Pedido() {}

    public Pedido(BigDecimal pedTotal, String pedDireccionEntrega, String pedMetodoEnvio,
                  Integer clienteUsuarioUsuId, Integer facturaFacId) {
        this.pedFecha = LocalDateTime.now();
        this.pedEstado = "PENDIENTE";
        this.pedTotal = pedTotal;
        this.pedDireccionEntrega = pedDireccionEntrega;
        this.pedMetodoEnvio = pedMetodoEnvio;
        this.clienteUsuarioUsuId = clienteUsuarioUsuId;
        this.facturaFacId = facturaFacId;
    }

    // ====== Getters y Setters ======

    public Integer getPedId() {
        return pedId;
    }

    public void setPedId(Integer pedId) {
        this.pedId = pedId;
    }

    public LocalDateTime getPedFecha() {
        return pedFecha;
    }

    public void setPedFecha(LocalDateTime pedFecha) {
        this.pedFecha = pedFecha;
    }

    public String getPedEstado() {
        return pedEstado;
    }

    public void setPedEstado(String pedEstado) {
        this.pedEstado = pedEstado;
    }

    public BigDecimal getPedTotal() {
        return pedTotal;
    }

    public void setPedTotal(BigDecimal pedTotal) {
        this.pedTotal = pedTotal;
    }

    public String getPedDireccionEntrega() {
        return pedDireccionEntrega;
    }

    public void setPedDireccionEntrega(String pedDireccionEntrega) {
        this.pedDireccionEntrega = pedDireccionEntrega;
    }

    public String getPedMetodoEnvio() {
        return pedMetodoEnvio;
    }

    public void setPedMetodoEnvio(String pedMetodoEnvio) {
        this.pedMetodoEnvio = pedMetodoEnvio;
    }

    public Integer getClienteUsuarioUsuId() {
        return clienteUsuarioUsuId;
    }

    public void setClienteUsuarioUsuId(Integer clienteUsuarioUsuId) {
        this.clienteUsuarioUsuId = clienteUsuarioUsuId;
    }

    public Integer getFacturaFacId() {
        return facturaFacId;
    }

    public void setFacturaFacId(Integer facturaFacId) {
        this.facturaFacId = facturaFacId;
    }
}
