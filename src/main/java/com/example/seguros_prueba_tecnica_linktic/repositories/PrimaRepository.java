package com.example.seguros_prueba_tecnica_linktic.repositories;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.models.Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrimaRepository extends JpaRepository<Prima,Integer> {
    @Query(value = "SELECT * " +
            "FROM primas p " +
            "WHERE p.edad_maxima >= :edad AND p.edad_minima <= :edad", nativeQuery = true)
    List<Prima> findAmparosAplicablesPorEdad(@Param("edad") int edad);

}
