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

import com.example.demo.Entity.c_CodigoPostal;
import com.example.demo.Repository.c_CodigoPostalRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/CodigoPostal")
public class c_CodigoPostalController {
    @Autowired
    private c_CodigoPostalRepository codigoPostalRepository;

    @GetMapping
    public List<c_CodigoPostal> datos() {
        return (List<c_CodigoPostal>) codigoPostalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_CodigoPostal> createRegistro(@RequestBody c_CodigoPostal var) {
        try {
            c_CodigoPostal codigoPostal = codigoPostalRepository.save(var);
            return new ResponseEntity<>(codigoPostal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{codpostal}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("codpostal") String codpostal) {
        try {
            codigoPostalRepository.deleteById(codpostal);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{codpostal}")
    public ResponseEntity<c_CodigoPostal> updatingRegistro(@PathVariable("codpostal") String idCodPostal, @RequestBody c_CodigoPostal cCodPostal){
        Optional<c_CodigoPostal> codPostalData = codigoPostalRepository.findById(idCodPostal);
        
        if(codPostalData.isPresent()){
            c_CodigoPostal codigoPostal =  codPostalData.get();
            codigoPostal.setCCodigoPostal(cCodPostal.getCCodigoPostal());
            codigoPostal.setEstado(cCodPostal.getEstado());
            codigoPostal.setStatus(cCodPostal.getStatus());
            return new ResponseEntity<>(codigoPostalRepository.save((codigoPostal)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
