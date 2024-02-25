package com.example.seguros_prueba_tecnica_linktic.controllers;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.repositories.AmparoRepository;
import com.example.seguros_prueba_tecnica_linktic.services.AmparoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/amparo")
public class AmparoController {
    @Autowired
    private AmparoService amparoService;

    @GetMapping()
    public ArrayList<Amparo> getAmaparos(){
        return amparoService.getAmparo();
    }


}
