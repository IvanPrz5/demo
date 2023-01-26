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

import com.example.demo.Entity.c_ObjetoImp;
import com.example.demo.Repository.c_ObjetoImpRepostory;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/ObjetoImp")
public class c_ObjetoImpController {
    @Autowired
    private c_ObjetoImpRepostory objetoimpRepository;

    @GetMapping
    public List<c_ObjetoImp> datos() {
        return (List<c_ObjetoImp>) objetoimpRepository.findAll();
    }

    @GetMapping(value = "/{cobjetoimp}")
    public Optional<c_ObjetoImp> data(@PathVariable("cobjetoimp") String cobjetoimp) {
        return objetoimpRepository.findById(cobjetoimp);
    }

    @PostMapping
    public ResponseEntity<c_ObjetoImp> createRegistro(@RequestBody c_ObjetoImp var) {
        try {
            c_ObjetoImp objetoimp = objetoimpRepository.save(var);
            return new ResponseEntity<>(objetoimp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cobjetoimp}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cobjetoimp") String cobjetoimp) {
        try {
            objetoimpRepository.deleteById(cobjetoimp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cobjetoimp}")
    public ResponseEntity<c_ObjetoImp> updatingRegistro(@PathVariable("cobjetoimp") String idObjetoImp, @RequestBody c_ObjetoImp cObjetoImp){
        Optional<c_ObjetoImp> objetoImpData = objetoimpRepository.findById(idObjetoImp);
        
        if(objetoImpData.isPresent()){
            c_ObjetoImp objetoImp =  objetoImpData.get();
            objetoImp.setId(cObjetoImp.getId());
            objetoImp.setDescripcion(cObjetoImp.getDescripcion());
            objetoImp.setStatus(cObjetoImp.getStatus());
            return new ResponseEntity<>(objetoimpRepository.save(objetoImp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
