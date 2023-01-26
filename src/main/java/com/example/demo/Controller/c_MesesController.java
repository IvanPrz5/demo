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

import com.example.demo.Entity.c_Meses;
import com.example.demo.Repository.c_MesesRepository;
import com.example.demo.Service.c_MesesService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Meses")
public class c_MesesController {
    @Autowired
    private c_MesesRepository mesesRepository;
    @Autowired 
    private c_MesesService mesesService;

    @GetMapping
    public List<c_Meses> datos() {
        return (List<c_Meses>) mesesRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Meses> createRegistro(@RequestBody c_Meses var) {
        try {
            c_Meses meses = mesesRepository.save(var);
            return new ResponseEntity<>(meses, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cmeses}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cmeses") String cmeses) {
        try {
            mesesRepository.deleteById(cmeses);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cmeses}")
    public ResponseEntity<c_Meses> updatingRegistro(@PathVariable("cmeses") String idMeses, @RequestBody c_Meses cMeses){
        Optional<c_Meses> mesesData = mesesRepository.findById(idMeses);
        
        if(mesesData.isPresent()){
            c_Meses meses = mesesData.get();
            meses.setId(cMeses.getId());
            meses.setDescripcion(cMeses.getDescripcion());
            meses.setStatus(cMeses.getStatus());
            return new ResponseEntity<>(mesesRepository.save((meses)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
