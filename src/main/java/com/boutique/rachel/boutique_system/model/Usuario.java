package com.boutique.rachel.boutique_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


public class Usuario {

    @Column(name = "usuId")
    private Integer usuId;

    @Column(name = "usuNombre", nullable = false, length = 45)
    private String usuNombre;

    @Column(name = "usuApellido", nullable = false, length = 45)
    private String usuApellido;

    @Column(name = "usuEmail", nullable = false, unique = true, length = 45)
    private String usuEmail;

    @Column(name = "usuPassword", nullable = false, length = 60)
    private String usuPassword;

    @Column(name = "usuEstado", nullable = false)
    private Boolean usuEstado = true;

    @Column(name = "usuTelefono", length = 15)
    private String usuTelefono;

    @Column(name = "usuTipoDocumento", nullable = false, length = 10)
    private String usuTipoDocumento;

    @Column(name = "usuNumeroDocumento", nullable = false, length = 20)
    private String usuNumeroDocumento;

    @Column(name = "usuFechaCreacion", nullable = false)
    private LocalDateTime usuFechaCreacion = LocalDateTime.now();

    public Usuario() {}

    public Usuario(String usuNombre, String usuApellido, String usuEmail, String usuPassword,
                   String usuTipoDocumento, String usuNumeroDocumento) {
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuEmail = usuEmail;
        this.usuPassword = usuPassword;
        this.usuTipoDocumento = usuTipoDocumento;
        this.usuNumeroDocumento = usuNumeroDocumento;
        this.usuEstado = true;
        this.usuFechaCreacion = LocalDateTime.now();
    }

    public Usuario(String usuNombre, String usuApellido, String usuEmail, String usuPassword,
                   String usuTelefono, String usuTipoDocumento, String usuNumeroDocumento) {
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuEmail = usuEmail;
        this.usuPassword = usuPassword;
        this.usuTelefono = usuTelefono;
        this.usuTipoDocumento = usuTipoDocumento;
        this.usuNumeroDocumento = usuNumeroDocumento;
        this.usuEstado = true;
        this.usuFechaCreacion = LocalDateTime.now();
    }

    // ================================
    // GETTERS Y SETTERS
    // ================================

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public String getUsuTipoDocumento() {
        return usuTipoDocumento;
    }

    public void setUsuTipoDocumento(String usuTipoDocumento) {
        this.usuTipoDocumento = usuTipoDocumento;
    }

    public String getUsuNumeroDocumento() {
        return usuNumeroDocumento;
    }

    public void setUsuNumeroDocumento(String usuNumeroDocumento) {
        this.usuNumeroDocumento = usuNumeroDocumento;
    }

    public LocalDateTime getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(LocalDateTime usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    // ================================
    // MÉTODOS ÚTILES
    // ================================

    public String getNombreCompleto() {
        return usuNombre + " " + usuApellido;
    }

    public boolean isActivo() {
        return usuEstado != null && usuEstado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuId=" + usuId +
                ", usuNombre='" + usuNombre + '\'' +
                ", usuApellido='" + usuApellido + '\'' +
                ", usuEmail='" + usuEmail + '\'' +
                ", usuEstado=" + usuEstado +
                ", usuTipoDocumento='" + usuTipoDocumento + '\'' +
                ", usuNumeroDocumento='" + usuNumeroDocumento + '\'' +
                ", usuFechaCreacion=" + usuFechaCreacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return usuId != null && usuId.equals(usuario.usuId);
    }

    @Override
    public int hashCode() {
        return usuId != null ? usuId.hashCode() : 0;
    }

}


