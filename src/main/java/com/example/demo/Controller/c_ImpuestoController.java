package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Impuesto;
import com.example.demo.Repository.c_ImpuestoRepository;
import com.example.demo.Service.c_ImpuestoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/Impuesto")
public class c_ImpuestoController {
    @Autowired
    private c_ImpuestoRepository impuestoRepository;

    @GetMapping
    public List<c_Impuesto> datos() {
        return (List<c_Impuesto>) impuestoRepository.findAll();
    }

    @GetMapping(value = "/{cimpuesto}")
    public Optional<c_Impuesto> data(@PathVariable("cimpuesto") String cimpuesto) {
        return impuestoRepository.findById(cimpuesto);
    }

    @PostMapping("/algo")
    public c_Impuesto create(@RequestBody c_Impuesto algo){
        return impuestoRepository.save(algo);
    }
}
