package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_TipoDeComprobante;
import com.example.demo.Repository.c_TipoComRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/TipoComprobante")
public class c_TipoComController {
    @Autowired
    private c_TipoComRepository tipocomRepository;

    @GetMapping
    public List<c_TipoDeComprobante> datos() {
        return (List<c_TipoDeComprobante>) tipocomRepository.findAll();
    }
}
