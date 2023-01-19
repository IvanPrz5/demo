package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.c_ObjetoImp;

public interface c_ObjetoImpRepostory extends JpaRepository <c_ObjetoImp, String> {
    
}
