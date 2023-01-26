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

import com.example.demo.Entity.c_Localidad;
import com.example.demo.Repository.c_LocalidadRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Localidad")
public class c_LocalidadController {
    @Autowired
    private c_LocalidadRepository localidadRepository;

    @GetMapping
    public List<c_Localidad> datos() {
        return (List<c_Localidad>) localidadRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Localidad> createRegistro(@RequestBody c_Localidad var) {
        try {
            c_Localidad localidad = localidadRepository.save(var);
            return new ResponseEntity<>(localidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{clocalidad}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("clocalidad") String clocalidad) {
        try {
            localidadRepository.deleteById(clocalidad);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clocalidad}")
    public ResponseEntity<c_Localidad> updatingRegistro(@PathVariable("clocalidad") String idLocalidad, @RequestBody c_Localidad cLocalidad){
        Optional<c_Localidad> localidadData = localidadRepository.findById(idLocalidad);
        
        if(localidadData.isPresent()){
            c_Localidad localidad = localidadData.get();
            localidad.setCLocalidad(cLocalidad.getCLocalidad());
            localidad.setDescripcion(cLocalidad.getDescripcion());
            localidad.setEstado(cLocalidad.getEstado());
            localidad.setStatus(cLocalidad.getStatus());
            return new ResponseEntity<>(localidadRepository.save((localidad)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
