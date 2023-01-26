package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_Moneda;
import com.example.demo.Repository.c_MonedaRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Moneda")
public class c_MonedaController {
    @Autowired
    private c_MonedaRepository monedaRepository;

    @GetMapping
    public List<c_Moneda> datos() {
        return (List<c_Moneda>) monedaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Moneda> createRegistro(@RequestBody c_Moneda var) {
        try {
            c_Moneda moneda = monedaRepository.save(var);
            return new ResponseEntity<>(moneda, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cmoneda}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cmoneda") String cmoneda) {
        try {
            monedaRepository.deleteById(cmoneda);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cmoneda}")
    public ResponseEntity<c_Moneda> updatingRegistro(@PathVariable("cmoneda") String idMoneda, @RequestBody c_Moneda cMoneda){
        Optional<c_Moneda> monedaData = monedaRepository.findById(idMoneda);
        
        if(monedaData.isPresent()){
            c_Moneda moneda = monedaData.get();
            moneda.setId(cMoneda.getId());
            moneda.setDescripcion(cMoneda.getDescripcion());
            moneda.setStatus(cMoneda.getStatus());
            return new ResponseEntity<>(monedaRepository.save((moneda)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
