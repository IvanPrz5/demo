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

import com.example.demo.Entity.c_FormaPago;
import com.example.demo.Repository.c_FormaPagoRepository;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/FormaPago")
public class c_FormaPagoController {
    @Autowired
    private c_FormaPagoRepository formaPagoRepository;

    @GetMapping
    public List<c_FormaPago> datos() {
        return (List<c_FormaPago>) formaPagoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_FormaPago> createRegistro(@RequestBody c_FormaPago var) {
        try {
            c_FormaPago formaPago = formaPagoRepository.save(var);
            return new ResponseEntity<>(formaPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cformapago}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cformapago") String cformapago) {
        try {
            formaPagoRepository.deleteById(cformapago);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cformapago}")
    public ResponseEntity<c_FormaPago> updatingRegistro(@PathVariable("cformapago") String idFormaPago, @RequestBody c_FormaPago cFormaPago){
        Optional<c_FormaPago> formaPagoData = formaPagoRepository.findById(idFormaPago);
        
        if(formaPagoData.isPresent()){
            c_FormaPago formaPago = formaPagoData.get();
            formaPago.setCFormaPago(cFormaPago.getCFormaPago());
            formaPago.setBancarizado(cFormaPago.getBancarizado());
            formaPago.setNombreBancoEmisorExtranjero(cFormaPago.getNombreBancoEmisorExtranjero());
            formaPago.setDescripcion(cFormaPago.getDescripcion());
            formaPago.setStatus(cFormaPago.getStatus());
            return new ResponseEntity<>(formaPagoRepository.save((formaPago)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
