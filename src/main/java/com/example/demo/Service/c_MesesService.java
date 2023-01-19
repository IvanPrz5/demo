package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.c_Meses;
import com.example.demo.Repository.c_MesesRepository;

@Service
public class c_MesesService {
    @Autowired
    c_MesesRepository mesesRepository;
    
    public void guardarUsuario(c_Meses mes){
        mesesRepository.save(mes);
    }
}
