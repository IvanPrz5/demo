package com.example.demo.Entity;

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
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="estado")
public class c_Estado {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String cEstado;
    @Column
    private String nombreEstado;
    @Column
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="id")
    private c_Pais pais;

    /* @OneToMany(mappedBy = "cLocalidad")
    private List<c_Localidad> localidades;

    @OneToMany(mappedBy = "cMunicipio")
    private List<c_Municipio> municipios;

    @OneToMany(mappedBy = "cCodigoPostal")
    private List<c_CodigoPostal> codigos; */
}