package com.example.seguros_prueba_tecnica_linktic.repositories;

import com.example.seguros_prueba_tecnica_linktic.models.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AseguradoRepository extends JpaRepository<Asegurado, Integer> {

    @Query(value = "SELECT * FROM Asegurados WHERE numero_identificacion = :numeroIdentificacion", nativeQuery = true)
    Asegurado findByNumeroIdentificacion(@Param("numeroIdentificacion") String numeroIdentificacion);
}
