package com.example.seguros_prueba_tecnica_linktic.services;

import com.example.seguros_prueba_tecnica_linktic.models.*;
import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoAmparoList;
import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoRequestDTO;
import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoResponseDTO;
import com.example.seguros_prueba_tecnica_linktic.repositories.AseguradoAmparoListRepository;
import com.example.seguros_prueba_tecnica_linktic.repositories.AseguradoRepository;
import com.example.seguros_prueba_tecnica_linktic.repositories.PrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AseguradoService {

    @Autowired
    AseguradoRepository aseguradoRepository;
    @Autowired
    AseguradoAmparoListRepository aseguradoAmparoListRepository;
    @Autowired
    AmparoService amparoService;
    @Autowired
    PrimaService primaService;

    public AseguradoReport calcularLiquidacion(AseguradoRequestDTO aseguradoRequest) throws Exception {
        if (aseguradoRequest.getValorAsegurado() <= 0) {
            throw new Exception("El valor asegurado debe ser mayor a cero.");
        }

        Asegurado asegurado = aseguradoRepository.findByNumeroIdentificacion(aseguradoRequest.getNroIdentificacion());
        if (!asegurado.getTipoIdentificacion().equals(aseguradoRequest.getTipoIdentificacion())) {
            throw new Exception("Tipo de documento de la solicitud, no coincide con el de la base de datos.");
        }
        if (asegurado == null) {
            throw new Exception("No se encontró el asegurado con el número de identificación proporcionado.");
        }
        //valido la edad del asegurado
        int edad = getEdadAsegurado(asegurado);
        //lista de los valores de prima que aplican por cliente
        Float valorAsegurado = aseguradoRequest.getValorAsegurado();
        List<Prima> primasFiltradas = valoresPrimaList(edad, asegurado);
        Float valorSeguro = valorSeguro(primasFiltradas, valorAsegurado);

        AseguradoReport reporte = new AseguradoReport();
        List<Liquidacion> liquidaciones = new ArrayList<>();

        return getAseguradoReport(aseguradoRequest, primasFiltradas, liquidaciones);
    }

    private static AseguradoReport getAseguradoReport(AseguradoRequestDTO aseguradoRequest, List<Prima> primasFiltradas, List<Liquidacion> liquidaciones) {
        // Construir la respuesta
        AseguradoReport report = new AseguradoReport();
        report.setTipoIdentificación(aseguradoRequest.getTipoIdentificacion());
        report.setNumeroIdentificacion(aseguradoRequest.getNroIdentificacion());
        report.setValorAsegurado(aseguradoRequest.getValorAsegurado());
        double valorTotal = 0.0f;

        for (Prima prima : primasFiltradas) {
            Liquidacion liquidacion = new Liquidacion();
            liquidacion.setCodigoAmparo(prima.getAmparo().getIdAmparo().toString());
            liquidacion.setNombreAmparo(prima.getAmparo().getNombre());
            liquidacion.setValorPrima(prima.getPorcentajePrima() * aseguradoRequest.getValorAsegurado());

            valorTotal += liquidacion.getValorPrima();
            liquidaciones.add(liquidacion);
        }

        report.setLiquidacion(liquidaciones);
        report.setValorTotal((float) valorTotal);
        return report;
    }

    private static Float valorSeguro(List<Prima> valoresPrimas, Float valorAsegurado) {
        return valoresPrimas.stream()
                .map(prima -> prima.getPorcentajePrima() * valorAsegurado) // Acceder a porcentajePrima
                .reduce(0.0f, Float::sum);
    }


    private List<Prima> valoresPrimaList(int edad, Asegurado asegurado) throws Exception {
        // Extraigo las primas válidas para esas edades
        List<Prima> amparosAplicables = primaService.findAmparosAplicablesPorEdad(edad);
        if (amparosAplicables.isEmpty()) {
            throw new Exception("Asegurado sin amparos, edad del asegurado => " + edad + " años");
        }
        // Listado de amparos según id del asegurado
        List<Integer> idAmparosDelAsegurado = aseguradoAmparoListRepository.findByIdAsegurado(asegurado.getIdAsegurado())
                .stream()
                .map(AseguradoAmparoList::getAmparo)
                .map(Amparo::getIdAmparo)
                .collect(Collectors.toList());

        // Filtrar amparosAplicables para mantener solo aquellos cuyo codigo_amparo esté en idAmparosDelAsegurado
        return amparosAplicables.stream()
                .filter(prima -> idAmparosDelAsegurado.contains(prima.getAmparo().getIdAmparo()))
                .collect(Collectors.toList());
    }


    private int getEdadAsegurado(Asegurado asegurado) {
        Date fechaNacimientoDate = asegurado.getFechaNacimiento();
        LocalDate fechaNacimiento = fechaNacimientoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int edad = periodo.getYears();
        return edad;
    }

    public ArrayList<Asegurado> getAsegurado() {
        return (ArrayList<Asegurado>) aseguradoRepository.findAll();
    }
}

