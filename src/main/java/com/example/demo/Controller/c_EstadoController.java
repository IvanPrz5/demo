package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Estado;
import com.example.demo.Repository.c_EstadoRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Estado")
public class c_EstadoController {
    @Autowired
    private c_EstadoRepository estadoRepository;

    @GetMapping
    public List<c_Estado> datos() {
        return (List<c_Estado>) estadoRepository.findAll();
    }
}
