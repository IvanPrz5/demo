package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="codigo_postal")
public class c_CodigoPostal {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String cCodigoPostal;
    @Column
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="cEstado")
    private c_Estado estado;

    @ManyToOne
    @JoinColumn(name="id_municipio")
    private c_Municipio municipios;

    @ManyToOne
    @JoinColumn(name="id_localidad")
    private c_Localidad localidades;

    /* @OneToMany(mappedBy = "idAsentamiento")
    private List<c_Asentamientos> asentamientos; */
}
