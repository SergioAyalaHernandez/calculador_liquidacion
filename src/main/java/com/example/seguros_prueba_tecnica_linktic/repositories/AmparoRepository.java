package com.example.seguros_prueba_tecnica_linktic.repositories;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmparoRepository extends JpaRepository<Amparo, Integer> {

}
