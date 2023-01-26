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
import com.example.demo.Entity.c_Aduana;
import com.example.demo.Repository.c_AduanaRepository;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Aduana")
public class c_AduanaController {
    @Autowired
    private c_AduanaRepository aduanaRepository;

    @GetMapping
    public List<c_Aduana> datos() {
        return (List<c_Aduana>) aduanaRepository.findAll();
    }

    @GetMapping(value = "/{caduana}")
    public Optional<c_Aduana> data(@PathVariable("caduana") String caduana) {
        return aduanaRepository.findById(caduana);
    }

    @PostMapping
    public ResponseEntity<c_Aduana> createRegistro(@RequestBody c_Aduana var) {
        try {
            c_Aduana aduana = aduanaRepository.save(var);
            return new ResponseEntity<>(aduana, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{caduana}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("caduana") String caduana) {
        try {
            aduanaRepository.deleteById(caduana);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{caduana}")
    public ResponseEntity<c_Aduana> updatingRegistro(@PathVariable("caduana") String idAduana, @RequestBody c_Aduana cAduana){
        Optional<c_Aduana> aduanaData = aduanaRepository.findById(idAduana);
        
        if(aduanaData.isPresent()){
            c_Aduana aduana =  aduanaData.get();
            aduana.setId(cAduana.getId());
            aduana.setDescripcion(cAduana.getDescripcion());
            aduana.setStatus(cAduana.getStatus());
            return new ResponseEntity<>(aduanaRepository.save(aduana), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}