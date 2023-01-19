package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Periodicidad;
import com.example.demo.Repository.c_PeriodicidadRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Periodicidad")
public class c_PeriodicidadController {
    @Autowired
    private c_PeriodicidadRepository periodicidadRepository;

    @GetMapping
    public List<c_Periodicidad> datos() {
        return (List<c_Periodicidad>) periodicidadRepository.findAll();
    }
}
