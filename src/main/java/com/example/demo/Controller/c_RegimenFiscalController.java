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

import com.example.demo.Entity.c_RegimenFiscal;
import com.example.demo.Repository.c_RegimenFiscalRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/RegimenFiscal")
public class c_RegimenFiscalController {
    @Autowired
    private c_RegimenFiscalRepository regimenfiscalRepository;

    @GetMapping
    public List<c_RegimenFiscal> datos() {
        return (List<c_RegimenFiscal>) regimenfiscalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_RegimenFiscal> createRegistro(@RequestBody c_RegimenFiscal var) {
        try {
            c_RegimenFiscal regimenFiscal = regimenfiscalRepository.save(var);
            return new ResponseEntity<>(regimenFiscal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cregimenfiscal}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cregimenfiscal") String cregimenfiscal ) {
        try {
            regimenfiscalRepository.deleteById(cregimenfiscal);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cregimenfiscal}")
    public ResponseEntity<c_RegimenFiscal> updatingRegistro(@PathVariable("cregimenfiscal") String idRegimenF, @RequestBody c_RegimenFiscal cRegimenF){
        Optional<c_RegimenFiscal> regimenFData = regimenfiscalRepository.findById(idRegimenF);
        
        if(regimenFData.isPresent()){
            c_RegimenFiscal regimenFiscal = regimenFData.get();
            regimenFiscal.setId(cRegimenF.getId());
            regimenFiscal.setDescripcion(cRegimenF.getDescripcion());
            regimenFiscal.setFisica(cRegimenF.getFisica());
            regimenFiscal.setMoral(cRegimenF.getMoral());
            regimenFiscal.setStatus(cRegimenF.getStatus());
            return new ResponseEntity<>(regimenfiscalRepository.save((regimenFiscal)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
