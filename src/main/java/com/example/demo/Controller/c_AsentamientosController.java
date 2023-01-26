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

import java.util.List;
import java.util.Optional;

import com.example.demo.Repository.c_AsentamientosRepository;
import com.example.demo.Entity.c_Asentamientos;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Asentamientos")
public class c_AsentamientosController {
    @Autowired
    private c_AsentamientosRepository asentamientosRepository;

    @GetMapping
    public List<c_Asentamientos> datos() {
        return (List<c_Asentamientos>) asentamientosRepository.findAll();
    }

    @GetMapping(value = "/{casentamiento}")
    public Optional<c_Asentamientos> data(@PathVariable("casentamiento") String casentamiento) {
        return asentamientosRepository.findById(casentamiento);
    }

    @PostMapping
    public ResponseEntity<c_Asentamientos> createRegistro(@RequestBody c_Asentamientos var) {
        try {
            c_Asentamientos asentamientos = asentamientosRepository.save(var);
            return new ResponseEntity<>(asentamientos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{casentamiento}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("casentamiento") String casentamiento) {
        try {
            asentamientosRepository.deleteById(casentamiento);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{casentamiento}")
    public ResponseEntity<c_Asentamientos> updatingRegistro(@PathVariable("casentamiento") String idAsentamiento, @RequestBody c_Asentamientos cAsentamiento){
        Optional<c_Asentamientos> asentamientosData = asentamientosRepository.findById(idAsentamiento);
        
        if(asentamientosData.isPresent()){
            c_Asentamientos asentamientos = asentamientosData.get();
            asentamientos.setCAsentamiento(cAsentamiento.getCAsentamiento());
            asentamientos.setNombre(cAsentamiento.getNombre());
            asentamientos.setTipo(cAsentamiento.getTipo());
            asentamientos.setCodigoPostal(cAsentamiento.getCodigoPostal());
            asentamientos.setStatus(cAsentamiento.getStatus());
            return new ResponseEntity<>(asentamientosRepository.save(asentamientos), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
