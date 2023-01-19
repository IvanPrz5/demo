package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_ClaveProdServ;
import com.example.demo.Repository.c_ClaveProdServRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/ClaveProdServ")
public class c_ClaveProdServController {
    @Autowired
    private c_ClaveProdServRepository claveprodservRepository;

    @GetMapping
    public List<c_ClaveProdServ> datos() {
        return (List<c_ClaveProdServ>) claveprodservRepository.findAll();
    }
}
