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

import com.example.demo.Entity.c_NumPedimentoAduana;
import com.example.demo.Repository.c_NumPedAduanaRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })

@RestController
@RequestMapping("/NumPedimentoAduana")
public class c_NumPedAduanaController {
    @Autowired
    private c_NumPedAduanaRepository numpedaduanaRepository;

    @GetMapping
    public List<c_NumPedimentoAduana> datos() {
        return (List<c_NumPedimentoAduana>) numpedaduanaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_NumPedimentoAduana> createRegistro(@RequestBody c_NumPedimentoAduana var) {
        try {
            c_NumPedimentoAduana nPedAduana = numpedaduanaRepository.save(var);
            return new ResponseEntity<>(nPedAduana, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cnumpedaduana}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cnumpedaduana") String cnumpedaduana) {
        try {
            numpedaduanaRepository.deleteById(cnumpedaduana);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cnumpedaduana}")
    public ResponseEntity<c_NumPedimentoAduana> updatingRegistro(@PathVariable("cnumpedaduana") String idNPAduna, @RequestBody c_NumPedimentoAduana cNPAduana){
        Optional<c_NumPedimentoAduana> npAduanaData = numpedaduanaRepository.findById(idNPAduna);
        
        if(npAduanaData.isPresent()){
            c_NumPedimentoAduana nPedAduana = npAduanaData.get();
            nPedAduana.setCAduana(cNPAduana.getCAduana());
            nPedAduana.setPatente(cNPAduana.getPatente());
            nPedAduana.setStatus(cNPAduana.getStatus());
            return new ResponseEntity<>(numpedaduanaRepository.save((nPedAduana)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
