package com.example.seguros_prueba_tecnica_linktic.repositories;

import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoAmparoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AseguradoAmparoListRepository extends JpaRepository<AseguradoAmparoList, Integer> {
    @Query(value = "select * from aseguradosamparos where id_asegurado = ?",nativeQuery = true)
    List<AseguradoAmparoList> findByIdAsegurado(Integer idAsegurado);
}
