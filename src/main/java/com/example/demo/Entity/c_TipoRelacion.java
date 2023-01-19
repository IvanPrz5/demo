package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipoRelacion")
public class c_TipoRelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cTipoRelacion;
    @Column
    private String descripcion;
    @Column
    private Boolean status;
}