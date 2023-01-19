package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_MetodoPago;
import com.example.demo.Repository.c_MetodoPagoRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/MetodoPago")
public class c_MetodoPagoController {
    @Autowired
    private c_MetodoPagoRepository metodopagoRepository;

    @GetMapping
    public List<c_MetodoPago> datos() {
        return (List<c_MetodoPago>) metodopagoRepository.findAll();
    }
}
