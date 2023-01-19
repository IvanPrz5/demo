package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Aduana;
import com.example.demo.Repository.c_AduanaRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Aduana")
public class c_AduanaController {
    @Autowired
    private c_AduanaRepository aduanaRepository;

    @GetMapping
    public List<c_Aduana> datos() {
        return (List<c_Aduana>) aduanaRepository.findAll();
    }
}


