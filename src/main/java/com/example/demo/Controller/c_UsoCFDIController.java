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

import com.example.demo.Entity.c_UsoCFDI;
import com.example.demo.Repository.c_UsoCFDIRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/UsoCFDI")
public class c_UsoCFDIController {
    @Autowired
    private c_UsoCFDIRepository usocfdiRepository;

    @GetMapping
    public List<c_UsoCFDI> datos() {
        return (List<c_UsoCFDI>) usocfdiRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_UsoCFDI> createRegistro(@RequestBody c_UsoCFDI var) {
        try {
            c_UsoCFDI usoCFDI = usocfdiRepository.save(var);
            return new ResponseEntity<>(usoCFDI, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cusocfdi}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cusocfdi") String cusocfdi ) {
        try {
            usocfdiRepository.deleteById(cusocfdi);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cusocfdi}")
    public ResponseEntity<c_UsoCFDI> updatingRegistro(@PathVariable("cusocfdi") String idUsoCFDI, @RequestBody c_UsoCFDI cUsoCFDI){
        Optional<c_UsoCFDI> usocfdiData = usocfdiRepository.findById(idUsoCFDI);
        
        if(usocfdiData.isPresent()){
            c_UsoCFDI usoCFDI = usocfdiData.get();
            usoCFDI.setId(cUsoCFDI.getId());
            usoCFDI.setDescripcion(cUsoCFDI.getDescripcion());
            usoCFDI.setRegimenFiscalReceptor(cUsoCFDI.getRegimenFiscalReceptor());
            usoCFDI.setFisica(cUsoCFDI.getFisica());
            usoCFDI.setMoral(cUsoCFDI.getMoral());
            usoCFDI.setStatus(cUsoCFDI.getStatus());
            return new ResponseEntity<>(usocfdiRepository.save((usoCFDI)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
