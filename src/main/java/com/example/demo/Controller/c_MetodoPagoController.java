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

import com.example.demo.Entity.c_MetodoPago;
import com.example.demo.Repository.c_MetodoPagoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/MetodoPago")
public class c_MetodoPagoController {
    @Autowired
    private c_MetodoPagoRepository metodopagoRepository;

    @GetMapping
    public List<c_MetodoPago> datos() {
        return (List<c_MetodoPago>) metodopagoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_MetodoPago> createRegistro(@RequestBody c_MetodoPago var) {
        try {
            c_MetodoPago metodoPago = metodopagoRepository.save(var);
            return new ResponseEntity<>(metodoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cmetodopago}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cmetodopago") String cmetodopago) {
        try {
            metodopagoRepository.deleteById(cmetodopago);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cmetodopago}")
    public ResponseEntity<c_MetodoPago> updatingRegistro(@PathVariable("cmetodopago") String idMetodoPago, @RequestBody c_MetodoPago cMetodoPago){
        Optional<c_MetodoPago> metodopagoData = metodopagoRepository.findById(idMetodoPago);
        
        if(metodopagoData.isPresent()){
            c_MetodoPago metodoPago = metodopagoData.get();
            metodoPago.setId(cMetodoPago.getId());
            metodoPago.setDescripcion(cMetodoPago.getDescripcion());
            metodoPago.setStatus(cMetodoPago.getStatus());
            return new ResponseEntity<>(metodopagoRepository.save((metodoPago)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
