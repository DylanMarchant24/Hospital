package com.duoc.hospital.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Medico")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_medico;

    @Column(length = 12)
    private String run;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false)
    private LocalDate fechaContrato;

    @Column(nullable = false, length = 10)
    private int sueldo_base;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(nullable = false, length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;



    public Medico(String run, String nombre, String apellido, LocalDate fechaContrato, int sueldoBase, String correo, String telefono, Especialidad especialidad) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContrato = fechaContrato;
        this.sueldo_base = sueldoBase;
        this.correo = correo;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }
}