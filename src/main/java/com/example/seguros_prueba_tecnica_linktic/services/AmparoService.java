package com.example.seguros_prueba_tecnica_linktic.services;

import com.example.seguros_prueba_tecnica_linktic.models.Amparo;
import com.example.seguros_prueba_tecnica_linktic.models.Prima;
import com.example.seguros_prueba_tecnica_linktic.repositories.AmparoRepository;
import com.example.seguros_prueba_tecnica_linktic.repositories.PrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmparoService {

    @Autowired
    AmparoRepository amparoRepository;

    public ArrayList<Amparo> getAmparo(){
        return (ArrayList<Amparo>) amparoRepository.findAll();
    }


}
