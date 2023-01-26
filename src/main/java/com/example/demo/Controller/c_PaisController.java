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

import com.example.demo.Entity.c_Pais;
import com.example.demo.Repository.c_PaisRepository;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Pais")
public class c_PaisController {
    @Autowired
    private c_PaisRepository paisRepository;

    @GetMapping
    public List<c_Pais> datos() {
        return (List<c_Pais>) paisRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Pais> createRegistro(@RequestBody c_Pais var) {
        try {
            c_Pais pais = paisRepository.save(var);
            return new ResponseEntity<>(pais, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cpais}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cpais") String cpais) {
        try {
            paisRepository.deleteById(cpais);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cpais}")
    public ResponseEntity<c_Pais> updatingRegistro(@PathVariable("cpais") String idPais, @RequestBody c_Pais cPais){
        Optional<c_Pais> paisData = paisRepository.findById(idPais);
        
        if(paisData.isPresent()){
            c_Pais pais =  paisData.get();
            pais.setId(cPais.getId());
            pais.setDescripcion(cPais.getDescripcion());
            pais.setStatus(cPais.getStatus());
            return new ResponseEntity<>(paisRepository.save(pais), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
