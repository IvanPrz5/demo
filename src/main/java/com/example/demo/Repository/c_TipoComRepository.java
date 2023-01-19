package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.c_TipoDeComprobante;

public interface c_TipoComRepository extends JpaRepository <c_TipoDeComprobante, String>{
    
}
