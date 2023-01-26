package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.c_Impuesto;

public interface c_ImpuestoRepository extends JpaRepository<c_Impuesto, String> {
   /*  public void guardar(c_Impuesto registro){
        registro.add(registro);
    } */
}
