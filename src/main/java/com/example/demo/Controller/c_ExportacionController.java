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

import com.example.demo.Entity.c_Exportacion;
import com.example.demo.Repository.c_ExportacionRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/Exportacion")
public class c_ExportacionController {
    @Autowired
    private c_ExportacionRepository exportacionRepository;

    @GetMapping
    public List<c_Exportacion> datos() {
        return (List<c_Exportacion>) exportacionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_Exportacion> createRegistro(@RequestBody c_Exportacion var) {
        try {
            c_Exportacion exportacion = exportacionRepository.save(var);
            return new ResponseEntity<>(exportacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cexportacion}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("cexportacion") String cexportacion) {
        try {
            exportacionRepository.deleteById(cexportacion);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cexportacion}")
    public ResponseEntity<c_Exportacion> updatingRegistro(@PathVariable("cexportacion") String idExportacion, @RequestBody c_Exportacion cExportacion){
        Optional<c_Exportacion> exportacionData = exportacionRepository.findById(idExportacion);
        
        if(exportacionData.isPresent()){
            c_Exportacion exportacion = exportacionData.get();
            exportacion.setId(cExportacion.getId());
            exportacion.setDescripcion(cExportacion.getDescripcion());
            exportacion.setStatus(cExportacion.getStatus());
            return new ResponseEntity<>(exportacionRepository.save((exportacion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
