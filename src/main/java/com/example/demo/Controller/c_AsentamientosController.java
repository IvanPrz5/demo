package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.Repository.c_AsentamientosRepository;
import com.example.demo.Entity.c_Asentamientos;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Asentamientos")
public class c_AsentamientosController {
    @Autowired
    private c_AsentamientosRepository asentamientosRepository;

    @GetMapping
    public List<c_Asentamientos> datos() {
        return (List<c_Asentamientos>) asentamientosRepository.findAll();
    }
}
