package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_RegimenFiscal;
import com.example.demo.Repository.c_RegimenFiscalRepository;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/RegimenFiscal")
public class c_RegimenFiscalController {
    @Autowired
    private c_RegimenFiscalRepository regimenfiscalRepository;

    @GetMapping
    public List<c_RegimenFiscal> datos() {
        return (List<c_RegimenFiscal>) regimenfiscalRepository.findAll();
    }
}
