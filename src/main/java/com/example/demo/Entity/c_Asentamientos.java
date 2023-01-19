package com.example.demo.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="asentamientos")
public class c_Asentamientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idAsentamiento;
    @Column
    private String cAsentamiento;
    @Column
    private String nombre;
    @Column
    private String tipo;
    @Column
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="cCodigoPostal")
    private c_CodigoPostal codigoPostal;
}
