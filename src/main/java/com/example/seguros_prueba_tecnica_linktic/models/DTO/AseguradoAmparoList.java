package com.example.seguros_prueba_tecnica_linktic.models.DTO;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.models.Asegurado;
import jakarta.persistence.*;

@Entity
@Table(name = "AseguradosAmparos")
public class AseguradoAmparoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAseguradoAmparo;

    @ManyToOne
    @JoinColumn(name = "id_asegurado", nullable = false)
    private Asegurado asegurado;

    @ManyToOne
    @JoinColumn(name = "id_amparo", nullable = false)
    private Amparo amparo;

    public Integer getIdAseguradoAmparo() {
        return idAseguradoAmparo;
    }

    public void setIdAseguradoAmparo(Integer idAseguradoAmparo) {
        this.idAseguradoAmparo = idAseguradoAmparo;
    }

    public Asegurado getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Asegurado asegurado) {
        this.asegurado = asegurado;
    }

    public Amparo getAmparo() {
        return amparo;
    }

    public void setAmparo(Amparo amparo) {
        this.amparo = amparo;
    }
}
