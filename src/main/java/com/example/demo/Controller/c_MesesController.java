package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Meses;
import com.example.demo.Repository.c_MesesRepository;
import com.example.demo.Service.c_MesesService;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Meses")
public class c_MesesController {
    @Autowired
    private c_MesesRepository mesesRepository;
    @Autowired 
    private c_MesesService mesesService;

    @GetMapping
    public List<c_Meses> datos() {
        return (List<c_Meses>) mesesRepository.findAll();
    }

    /*  */
}
