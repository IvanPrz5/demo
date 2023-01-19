package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_FormaPago;
import com.example.demo.Repository.c_FormaPagoRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/FormaPago")
public class c_FormaPagoController {
    @Autowired
    private c_FormaPagoRepository formaPagoRepository;

    @GetMapping
    public List<c_FormaPago> datos() {
        return (List<c_FormaPago>) formaPagoRepository.findAll();
    }
}
