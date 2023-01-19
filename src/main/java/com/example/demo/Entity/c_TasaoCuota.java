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
@Table(name="tasaOCuota")
public class c_TasaoCuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cTasaCuota;
    @Column
    private String rangoFijo;
    @Column
    private String valorMinimo;
    @Column
    private String valorMaximo;
    @Column
    private String impuesto;
    @Column
    private String factor;
    @Column
    private String traslado;
    @Column
    private String retencion;
    @Column
    private Boolean status;
}
