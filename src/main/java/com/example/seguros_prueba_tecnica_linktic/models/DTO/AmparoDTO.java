package com.example.seguros_prueba_tecnica_linktic.models.DTO;

public class AmparoDTO {
    private Integer codigoAmparo;
    private String nombreAmparo;
    private Float valorPrima;

    public Integer getCodigoAmparo() {
        return codigoAmparo;
    }

    public void setCodigoAmparo(Integer codigoAmparo) {
        this.codigoAmparo = codigoAmparo;
    }

    public String getNombreAmparo() {
        return nombreAmparo;
    }

    public void setNombreAmparo(String nombreAmparo) {
        this.nombreAmparo = nombreAmparo;
    }

    public Float getValorPrima() {
        return valorPrima;
    }

    public void setValorPrima(Float valorPrima) {
        this.valorPrima = valorPrima;
    }
}