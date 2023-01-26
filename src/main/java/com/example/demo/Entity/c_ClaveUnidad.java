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
@Table(name="claveUnidad")
public class c_ClaveUnidad {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String cClaveUnidad;
    @Column
    private String nombre;
    @Column(length = 600)
    private String descripcion;
    @Column
    private String simbolo;
    @Column
    private Boolean status;
}
