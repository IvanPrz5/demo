package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Exportacion;
import com.example.demo.Repository.c_ExportacionRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Exportacion")
public class c_ExportacionController {
    @Autowired
    private c_ExportacionRepository exportacionRepository;

    @GetMapping
    public List<c_Exportacion> datos() {
        return (List<c_Exportacion>) exportacionRepository.findAll();
    }
}
