package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.c_Moneda;

public interface c_MonedaRepository extends JpaRepository <c_Moneda, String> {
    
}
