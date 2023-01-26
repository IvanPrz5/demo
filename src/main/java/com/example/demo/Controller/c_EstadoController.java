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

import com.example.demo.Entity.c_Estado;
import com.example.demo.Repository.c_EstadoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Estado")
public class c_EstadoController {
    @Autowired
    private c_EstadoRepository estadoRepository;

    @GetMapping
    public List<c_Estado> datos() {
        return (List<c_Estado>) estadoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Estado> createRegistro(@RequestBody c_Estado var) {
        try {
            c_Estado estado = estadoRepository.save(var);
            return new ResponseEntity<>(estado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cestado}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cestado") String cestado) {
        try {
            estadoRepository.deleteById(cestado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cestado}")
    public ResponseEntity<c_Estado> updatingRegistro(@PathVariable("cestado") String idEstado, @RequestBody c_Estado cEstado){
        Optional<c_Estado> estadoData = estadoRepository.findById(idEstado);
        
        if(estadoData.isPresent()){
            c_Estado estado = estadoData.get();
            estado.setCEstado(cEstado.getCEstado());
            estado.setNombreEstado(cEstado.getNombreEstado());
            estado.setPais(cEstado.getPais());
            estado.setStatus(cEstado.getStatus());
            return new ResponseEntity<>(estadoRepository.save((estado)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
