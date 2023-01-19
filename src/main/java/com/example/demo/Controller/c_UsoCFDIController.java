package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_UsoCFDI;
import com.example.demo.Repository.c_UsoCFDIRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/UsoCFDI")
public class c_UsoCFDIController {
    @Autowired
    private c_UsoCFDIRepository usocfdiRepository;

    @GetMapping
    public List<c_UsoCFDI> datos() {
        return (List<c_UsoCFDI>) usocfdiRepository.findAll();
    }
}
