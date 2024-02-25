package com.example.seguros_prueba_tecnica_linktic.controllers;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.models.Asegurado;
import com.example.seguros_prueba_tecnica_linktic.models.AseguradoReport;
import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoRequestDTO;
import com.example.seguros_prueba_tecnica_linktic.services.AmparoService;
import com.example.seguros_prueba_tecnica_linktic.services.AseguradoService;
import com.example.seguros_prueba_tecnica_linktic.services.PrimaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    public ArrayList<Asegurado> getAsegurados() {
        return aseguradoService.getAsegurado();
    }

    @PostMapping("/calcularLiquidacion")
    @Operation(summary = "Calcula la liquidación para un asegurado",
            description = "Calcula la liquidación basada en el valor asegurado y los amparos aplicables por usuario" +
                    "el usuario debe contar con una edad especifica" +
                    "el usuario de la petición debe coincidir su tipo de documentación a la de la base de datos",

            responses = {
                    @ApiResponse(responseCode = "200", description = "Liquidación calculada exitosamente",
                            content = @Content(schema = @Schema(implementation = AseguradoReport.class))),
                    @ApiResponse(responseCode = "500", description = "Error al calcular la liquidación",
                            content = @Content(schema = @Schema(implementation = Map.class)))
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AseguradoRequestDTO.class),
                    examples = {
                            @ExampleObject(name = "Ejemplo 1", summary = "Ejemplo Detallado",
                                    description = "Una descripción del ejemplo",
                                    value = "{\n" +
                                            "    \"tipoIdentificacion\":\"CC\",\n" +
                                            "    \"nroIdentificacion\":\"32263665\",\n" +
                                            "    \"valorAsegurado\":9982660\n" +
                                            "}")
                    }
            )
    ))
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
