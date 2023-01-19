package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_TipoRelacion;
import com.example.demo.Repository.c_TipoRelacionRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/TipoController")
public class c_TipoRelacionController {
    @Autowired
    private c_TipoRelacionRepository tiporelacionRepository;

    @GetMapping
    public List<c_TipoRelacion> datos() {
        return (List<c_TipoRelacion>) tiporelacionRepository.findAll();
    }
}
