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

import com.example.demo.Entity.c_ClaveProdServ;
import com.example.demo.Repository.c_ClaveProdServRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/ClaveProdServ")
public class c_ClaveProdServController {
    @Autowired
    private c_ClaveProdServRepository claveprodservRepository;

    @GetMapping
    public List<c_ClaveProdServ> datos() {
        return (List<c_ClaveProdServ>) claveprodservRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_ClaveProdServ> createRegistro(@RequestBody c_ClaveProdServ var) {
        try {
            c_ClaveProdServ claveProdServ = claveprodservRepository.save(var);
            return new ResponseEntity<>(claveProdServ, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{claveprodserv}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("claveprodserv") String claveprodserv) {
        try {
            claveprodservRepository.deleteById(claveprodserv);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{claveprodserv}")
    public ResponseEntity<c_ClaveProdServ> updatingRegistro(@PathVariable("caduana") String idClavePS, @RequestBody c_ClaveProdServ cClavePS){
        Optional<c_ClaveProdServ> clavePSData = claveprodservRepository.findById(idClavePS);
        
        if(clavePSData.isPresent()){
            c_ClaveProdServ claveProdServ =  clavePSData.get();
            claveProdServ.setCClaveProdServ(cClavePS.getCClaveProdServ());
            claveProdServ.setDescripcion(cClavePS.getDescripcion());
            claveProdServ.setPalabrasSimilares(cClavePS.getPalabrasSimilares());
            claveProdServ.setStatus(cClavePS.getStatus());
            return new ResponseEntity<>(claveprodservRepository.save(claveProdServ), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
