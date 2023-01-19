package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Moneda;
import com.example.demo.Repository.c_MonedaRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Moneda")
public class c_MonedaController {
    @Autowired
    private c_MonedaRepository monedaRepository;

    @GetMapping
    public List<c_Moneda> datos() {
        return (List<c_Moneda>) monedaRepository.findAll();
    }
}
