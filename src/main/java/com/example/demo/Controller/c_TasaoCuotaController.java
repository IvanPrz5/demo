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

import com.example.demo.Repository.c_TasaoCuotaRepository;
import com.example.demo.Entity.c_TasaoCuota;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, })
@RestController
@RequestMapping("/TasaoCuota")
public class c_TasaoCuotaController {
    @Autowired
    private c_TasaoCuotaRepository tasaocuotaRepository;

    @GetMapping
    public List<c_TasaoCuota> datos() {
        return (List<c_TasaoCuota>) tasaocuotaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<c_TasaoCuota> createRegistro(@RequestBody c_TasaoCuota var) {
        try {
            c_TasaoCuota tasaoCuota = tasaocuotaRepository.save(var);
            return new ResponseEntity<>(tasaoCuota, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ctasacuota}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("ctasacuota") Integer ctasacuota ) {
        try {
            tasaocuotaRepository.deleteById(ctasacuota);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ctasacuota}")
    public ResponseEntity<c_TasaoCuota> updatingRegistro(@PathVariable("ctasacuota") Integer idTasaCuota, @RequestBody c_TasaoCuota cTasaoCuota){
        Optional<c_TasaoCuota> tasacuotaData = tasaocuotaRepository.findById(idTasaCuota);
        
        if(tasacuotaData.isPresent()){
            c_TasaoCuota tasaoCuota = tasacuotaData.get();
            tasaoCuota.setRangoFijo(cTasaoCuota.getRangoFijo());
            tasaoCuota.setValorMinimo(cTasaoCuota.getValorMinimo());
            tasaoCuota.setValorMaximo(cTasaoCuota.getValorMaximo());
            tasaoCuota.setImpuesto(cTasaoCuota.getImpuesto());
            tasaoCuota.setFactor(cTasaoCuota.getFactor());
            tasaoCuota.setTraslado(cTasaoCuota.getTraslado());
            tasaoCuota.setRetencion(cTasaoCuota.getRetencion());
            tasaoCuota.setStatus(cTasaoCuota.getStatus());
            return new ResponseEntity<>(tasaocuotaRepository.save((tasaoCuota)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
