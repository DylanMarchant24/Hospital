package com.duoc.hospital.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "prevision")
@AllArgsConstructor
@NoArgsConstructor
public class Prevision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prevision;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false  , length = 200)
    private int cobertura;

}
