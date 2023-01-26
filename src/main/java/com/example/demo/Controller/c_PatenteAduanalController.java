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

import com.example.demo.Entity.c_PatenteAduanal;
import com.example.demo.Repository.c_PatenteAduanalRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/PatenteAduanal")
public class c_PatenteAduanalController {
    @Autowired
    private c_PatenteAduanalRepository patenteaduanalRepository;

    @GetMapping
    public List<c_PatenteAduanal> datos() {
        return (List<c_PatenteAduanal>) patenteaduanalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_PatenteAduanal> createRegistro(@RequestBody c_PatenteAduanal var) {
        try {
            c_PatenteAduanal patenteAduanal = patenteaduanalRepository.save(var);
            return new ResponseEntity<>(patenteAduanal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cpatente}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cpatente") String cpatente) {
        try {
            patenteaduanalRepository.deleteById(cpatente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cpatente}")
    public ResponseEntity<c_PatenteAduanal> updatingRegistro(@PathVariable("cpatente") String idPatente, @RequestBody c_PatenteAduanal cPatente){
        Optional<c_PatenteAduanal> patenteData = patenteaduanalRepository.findById(idPatente);
        
        if(patenteData.isPresent()){
            c_PatenteAduanal patenteAduanal = patenteData.get();
            patenteAduanal.setCPatenteAduanal(cPatente.getCPatenteAduanal());
            patenteAduanal.setStatus(cPatente.getStatus());
            return new ResponseEntity<>(patenteaduanalRepository.save(patenteAduanal), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
