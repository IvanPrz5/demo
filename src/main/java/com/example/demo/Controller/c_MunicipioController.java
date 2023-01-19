package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Municipio;
import com.example.demo.Repository.c_MunicipioRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Municipio")
public class c_MunicipioController {
    @Autowired
    private c_MunicipioRepository municipioRepository;

    @GetMapping
    public List<c_Municipio> datos() {
        return (List<c_Municipio>) municipioRepository.findAll();
    }
}
