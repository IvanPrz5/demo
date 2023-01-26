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

import com.example.demo.Entity.c_TipoRelacion;
import com.example.demo.Repository.c_TipoRelacionRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/TipoRelacion")
public class c_TipoRelacionController {
    @Autowired
    private c_TipoRelacionRepository tiporelacionRepository;

    @GetMapping
    public List<c_TipoRelacion> datos() {
        return (List<c_TipoRelacion>) tiporelacionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_TipoRelacion> createRegistro(@RequestBody c_TipoRelacion var) {
        try {
            c_TipoRelacion tipoRelacion = tiporelacionRepository.save(var);
            return new ResponseEntity<>(tipoRelacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ctiporel}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("ctiporel") String ctiporel ) {
        try {
            tiporelacionRepository.deleteById(ctiporel);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ctiporel}")
    public ResponseEntity<c_TipoRelacion> updatingRegistro(@PathVariable("ctiporel") String idTipoRel, @RequestBody c_TipoRelacion cTipoRel){
        Optional<c_TipoRelacion> tipoRelData = tiporelacionRepository.findById(idTipoRel);
        
        if(tipoRelData.isPresent()){
            c_TipoRelacion tipoRelacion = tipoRelData.get();
            tipoRelacion.setId(cTipoRel.getId());
            tipoRelacion.setDescripcion(cTipoRel.getDescripcion());
            tipoRelacion.setStatus(cTipoRel.getStatus());
            return new ResponseEntity<>(tiporelacionRepository.save((tipoRelacion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
