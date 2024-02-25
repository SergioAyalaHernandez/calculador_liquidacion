package com.example.seguros_prueba_tecnica_linktic.controllers;

import com.example.seguros_prueba_tecnica_linktic.models.Prima;
import com.example.seguros_prueba_tecnica_linktic.services.PrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/prima")
public class PrimaController {

    @Autowired
    PrimaService primaService;

    @GetMapping()
    public ArrayList<Prima> getPrimas(){
        return primaService.getAmparo();
    }

}
