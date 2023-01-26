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

import com.example.demo.Entity.c_ClaveUnidad;
import com.example.demo.Repository.c_ClaveUnidadRepository;

import java.util.List;
import java.util.Optional;;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/ClaveUnidad")
public class c_ClaveUnidadController {
    @Autowired
    private c_ClaveUnidadRepository claveunidadRepository;

    @GetMapping
    public List<c_ClaveUnidad> datos() {
        return (List<c_ClaveUnidad>) claveunidadRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_ClaveUnidad> createRegistro(@RequestBody c_ClaveUnidad var) {
        try {
            c_ClaveUnidad claveUnidad = claveunidadRepository.save(var);
            return new ResponseEntity<>(claveUnidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{claveunidad}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("claveunidad") String claveunidad) {
        try {
            claveunidadRepository.deleteById(claveunidad);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{claveunidad}")
    public ResponseEntity<c_ClaveUnidad> updatingRegistro(@PathVariable("claveunidad") String idClaveUni, @RequestBody c_ClaveUnidad cClaveUni){
        Optional<c_ClaveUnidad> claveunidadData = claveunidadRepository.findById(idClaveUni);
        
        if(claveunidadData.isPresent()){
            c_ClaveUnidad claveUnidad = claveunidadData.get();
            claveUnidad.setCClaveUnidad(cClaveUni.getCClaveUnidad());
            claveUnidad.setNombre(cClaveUni.getNombre());
            claveUnidad.setDescripcion(cClaveUni.getDescripcion());
            claveUnidad.setSimbolo(cClaveUni.getSimbolo());
            claveUnidad.setStatus(cClaveUni.getStatus());
            return new ResponseEntity<>(claveunidadRepository.save(claveUnidad), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
