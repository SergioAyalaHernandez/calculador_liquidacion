package com.example.seguros_prueba_tecnica_linktic.models.DTO;

public class AseguradoRequestDTO {
    private String tipoIdentificacion;
    private String nroIdentificacion;
    private Float valorAsegurado;

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public Float getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(Integer valorAsegurado) {
        this.valorAsegurado = Float.valueOf(valorAsegurado);
    }
}
