package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_CodigoPostal;
import com.example.demo.Repository.c_CodigoPostalRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/CodigoPostal")
public class c_CodigoPostalController {
    @Autowired
    private c_CodigoPostalRepository codigoPostalRepository;

    @GetMapping
    public List<c_CodigoPostal> datos() {
        return (List<c_CodigoPostal>) codigoPostalRepository.findAll();
    }
}
