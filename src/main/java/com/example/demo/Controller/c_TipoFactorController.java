package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_TipoFactor;
import com.example.demo.Repository.c_TipoFactorRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/TipoFactor")
public class c_TipoFactorController {
    @Autowired
    private c_TipoFactorRepository tipofactorRepository;

    @GetMapping
    public List<c_TipoFactor> datos() {
        return (List<c_TipoFactor>) tipofactorRepository.findAll();
    }
}
