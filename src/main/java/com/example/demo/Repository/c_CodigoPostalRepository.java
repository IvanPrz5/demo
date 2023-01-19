package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.c_CodigoPostal;

public interface c_CodigoPostalRepository extends JpaRepository <c_CodigoPostal, String> {
    
}
