package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.c_ClaveUnidad;

public interface c_ClaveUnidadRepository extends JpaRepository <c_ClaveUnidad, String> {
    
}
