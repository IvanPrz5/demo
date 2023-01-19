package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_FormaPago;
import com.example.demo.Entity.c_PatenteAduanal;
import com.example.demo.Repository.c_FormaPagoRepository;
import com.example.demo.Repository.c_PatenteAduanalRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/PatenteAduanal")
public class c_PatenteAduanalController {
    @Autowired
    private c_PatenteAduanalRepository patenteaduanalRepository;

    @GetMapping
    public List<c_PatenteAduanal> datos() {
        return (List<c_PatenteAduanal>) patenteaduanalRepository.findAll();
    }
}
