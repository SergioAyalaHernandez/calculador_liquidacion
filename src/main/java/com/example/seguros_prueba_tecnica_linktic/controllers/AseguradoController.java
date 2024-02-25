package com.example.seguros_prueba_tecnica_linktic.controllers;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.models.Asegurado;
import com.example.seguros_prueba_tecnica_linktic.models.AseguradoReport;
import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoRequestDTO;
import com.example.seguros_prueba_tecnica_linktic.services.AmparoService;
import com.example.seguros_prueba_tecnica_linktic.services.AseguradoService;
import com.example.seguros_prueba_tecnica_linktic.services.PrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/asegurado")
public class AseguradoController {

    @Autowired
    private AseguradoService aseguradoService;

    @GetMapping()
    public ArrayList<Asegurado> getAsegurados(){
        return aseguradoService.getAsegurado();
    }

    @PostMapping("/calcularLiquidacion")
    public ResponseEntity<?> calcularLiquidacion(@RequestBody AseguradoRequestDTO aseguradoRequest) {
        try {
            AseguradoReport report = aseguradoService.calcularLiquidacion(aseguradoRequest);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error al calcular la liquidación", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }



}
