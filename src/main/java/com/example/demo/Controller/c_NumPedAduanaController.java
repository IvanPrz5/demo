package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_NumPedimentoAduana;
import com.example.demo.Repository.c_NumPedAduanaRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/NumPedimentoAduana")
public class c_NumPedAduanaController {
    @Autowired
    private c_NumPedAduanaRepository numpedaduanaRepository;

    @GetMapping
    public List<c_NumPedimentoAduana> datos() {
        return (List<c_NumPedimentoAduana>) numpedaduanaRepository.findAll();
    }
}
