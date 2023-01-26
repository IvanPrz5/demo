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

import com.example.demo.Entity.c_Periodicidad;
import com.example.demo.Repository.c_PeriodicidadRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Periodicidad")
public class c_PeriodicidadController {
    @Autowired
    private c_PeriodicidadRepository periodicidadRepository;

    @GetMapping
    public List<c_Periodicidad> datos() {
        return (List<c_Periodicidad>) periodicidadRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Periodicidad> createRegistro(@RequestBody c_Periodicidad var) {
        try {
            c_Periodicidad periodicidad = periodicidadRepository.save(var);
            return new ResponseEntity<>(periodicidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cperiodicidad}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cperiodicidad") String cperiodicidad) {
        try {
            periodicidadRepository.deleteById(cperiodicidad);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cperiodicidad}")
    public ResponseEntity<c_Periodicidad> updatingRegistro(@PathVariable("cperiodicidad") String idPeriodicidad, @RequestBody c_Periodicidad cPeriodicidad){
        Optional<c_Periodicidad> periodicidadData = periodicidadRepository.findById(idPeriodicidad);
        
        if(periodicidadData.isPresent()){
            c_Periodicidad periodicidad =  periodicidadData.get();
            periodicidad.setId(cPeriodicidad.getId());
            periodicidad.setDescripcion(cPeriodicidad.getDescripcion());
            periodicidad.setStatus(cPeriodicidad.getStatus());
            return new ResponseEntity<>(periodicidadRepository.save(periodicidad), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
