package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_ClaveUnidad;
import com.example.demo.Repository.c_ClaveUnidadRepository;

import java.util.List;
import java.util.Optional;;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/ClaveUnidad")
public class c_ClaveUnidadController {
    @Autowired
    private c_ClaveUnidadRepository claveunidadRepository;

    @GetMapping
    public List<c_ClaveUnidad> datos() {
        return (List<c_ClaveUnidad>) claveunidadRepository.findAll();
    }
}
