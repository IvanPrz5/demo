package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.Repository.c_TasaoCuotaRepository;
import com.example.demo.Entity.c_TasaoCuota;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/TasaoCuota")
public class c_TasaoCuotaController {
    @Autowired
    private c_TasaoCuotaRepository tasaocuotaRepository;

    @GetMapping
    public List<c_TasaoCuota> datos() {
        return (List<c_TasaoCuota>) tasaocuotaRepository.findAll();
    }
}
