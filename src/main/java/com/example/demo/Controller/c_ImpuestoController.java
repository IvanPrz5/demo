package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.example.demo.Entity.c_Impuesto;
import com.example.demo.Repository.c_ImpuestoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Impuesto")
public class c_ImpuestoController {
    @Autowired
    private c_ImpuestoRepository impuestoRepository;

    @GetMapping
    public List<c_Impuesto> datos() {
        return (List<c_Impuesto>) impuestoRepository.findAll();
    }

    @GetMapping(value = "/{cimpuesto}")
    public Optional<c_Impuesto> data(@PathVariable("cimpuesto") String cimpuesto) {
        return impuestoRepository.findById(cimpuesto);
    }

    @PostMapping
    public ResponseEntity<c_Impuesto> createRegistro(@RequestBody c_Impuesto var) {
        try {
            c_Impuesto impuesto = impuestoRepository.save(var);
            return new ResponseEntity<>(impuesto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cimpuesto}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cimpuesto") String cimpuesto) {
        try {
            impuestoRepository.deleteById(cimpuesto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cimpuesto}")
    public ResponseEntity<c_Impuesto> updatingRegistro(@PathVariable("cimpuesto") String idImpuesto, @RequestBody c_Impuesto cImpuesto){
        Optional<c_Impuesto> impuestoData = impuestoRepository.findById(idImpuesto);
        
        if(impuestoData.isPresent()){
            c_Impuesto impuesto =  impuestoData.get();
            impuesto.setId(cImpuesto.getId());
            impuesto.setDescripcion(cImpuesto.getDescripcion());
            impuesto.setRetencion(cImpuesto.getRetencion());
            impuesto.setTraslado(cImpuesto.getTraslado());
            impuesto.setLocalFederal(cImpuesto.getLocalFederal());
            impuesto.setStatus(cImpuesto.getStatus());
            return new ResponseEntity<>(impuestoRepository.save(impuesto), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
