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

import com.example.demo.Entity.c_TipoFactor;
import com.example.demo.Repository.c_TipoFactorRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/TipoFactor")
public class c_TipoFactorController {
    @Autowired
    private c_TipoFactorRepository tipofactorRepository;

    @GetMapping
    public List<c_TipoFactor> datos() {
        return (List<c_TipoFactor>) tipofactorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_TipoFactor> createRegistro(@RequestBody c_TipoFactor var) {
        try {
            c_TipoFactor tipoFactor = tipofactorRepository.save(var);
            return new ResponseEntity<>(tipoFactor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ctipofac}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("ctipofac") String ctipofac ) {
        try {
            tipofactorRepository.deleteById(ctipofac);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ctipofactor}")
    public ResponseEntity<c_TipoFactor> updatingRegistro(@PathVariable("ctipofac") String idTipoFac, @RequestBody c_TipoFactor cTipoFac){
        Optional<c_TipoFactor> tipoFacData = tipofactorRepository.findById(idTipoFac);
        
        if(tipoFacData.isPresent()){
            c_TipoFactor tipoFactor = tipoFacData.get();
            tipoFactor.setCTipoFactor(cTipoFac.getCTipoFactor());
            tipoFactor.setStatus(cTipoFac.getStatus());
            return new ResponseEntity<>(tipofactorRepository.save((tipoFactor)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
