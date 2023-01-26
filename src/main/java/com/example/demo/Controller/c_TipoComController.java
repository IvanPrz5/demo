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

import com.example.demo.Entity.c_TipoDeComprobante;
import com.example.demo.Repository.c_TipoComRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/TipoComprobante")
public class c_TipoComController {
    @Autowired
    private c_TipoComRepository tipocomRepository;

    @GetMapping
    public List<c_TipoDeComprobante> datos() {
        return (List<c_TipoDeComprobante>) tipocomRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_TipoDeComprobante> createRegistro(@RequestBody c_TipoDeComprobante var) {
        try {
            c_TipoDeComprobante tipoDeComprobante = tipocomRepository.save(var);
            return new ResponseEntity<>(tipoDeComprobante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ctipocom}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("ctipocom") String ctipocom ) {
        try {
            tipocomRepository.deleteById(ctipocom);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ctipocom}")
    public ResponseEntity<c_TipoDeComprobante> updatingRegistro(@PathVariable("ctipocom") String idTipoCom, @RequestBody c_TipoDeComprobante cTipoCom){
        Optional<c_TipoDeComprobante> tipocomData = tipocomRepository.findById(idTipoCom);
        
        if(tipocomData.isPresent()){
            c_TipoDeComprobante tipoDeComprobante = tipocomData.get();
            tipoDeComprobante.setId(cTipoCom.getId());
            tipoDeComprobante.setDescripcion(cTipoCom.getDescripcion());
            tipoDeComprobante.setStatus(cTipoCom.getStatus());
            return new ResponseEntity<>(tipocomRepository.save((tipoDeComprobante)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
