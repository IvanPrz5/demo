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

import com.example.demo.Entity.c_Municipio;
import com.example.demo.Repository.c_MunicipioRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Municipio")
public class c_MunicipioController {
    @Autowired
    private c_MunicipioRepository municipioRepository;

    @GetMapping
    public List<c_Municipio> datos() {
        return (List<c_Municipio>) municipioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Municipio> createRegistro(@RequestBody c_Municipio var) {
        try {
            c_Municipio municipio = municipioRepository.save(var);
            return new ResponseEntity<>(municipio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cmunicipio}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cmunicipio") String cmunicipio) {
        try {
            municipioRepository.deleteById(cmunicipio);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cmunicipio}")
    public ResponseEntity<c_Municipio> updatingRegistro(@PathVariable("cmunicipio") String idMunicipio, @RequestBody c_Municipio cMunicipio){
        Optional<c_Municipio> municipioData = municipioRepository.findById(idMunicipio);
        
        if(municipioData.isPresent()){
            c_Municipio municipio = municipioData.get();
            municipio.setCMunicipio(cMunicipio.getCMunicipio());
            municipio.setDescripcion(cMunicipio.getDescripcion());
            municipio.setEstado(cMunicipio.getEstado());
            municipio.setStatus(cMunicipio.getStatus());
            return new ResponseEntity<>(municipioRepository.save((municipio)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
