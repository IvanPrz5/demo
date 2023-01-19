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
@Table(name="numPedimentoAduana")
public class c_NumPedimentoAduana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNum;
    @Column
    private String cAduana;
    @Column
    private String patente;
    @Column
    private Boolean status;
}
