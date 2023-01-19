package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Localidad;
import com.example.demo.Repository.c_LocalidadRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Localidad")
public class c_LocalidadController {
    @Autowired
    private c_LocalidadRepository localidadRepository;

    @GetMapping
    public List<c_Localidad> datos() {
        return (List<c_Localidad>) localidadRepository.findAll();
    }
}
