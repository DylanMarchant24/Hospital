package com.duoc.hospital.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paciente;

    @Column(unique = true, length = 12, nullable = false)
    private String run;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false)
    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_prevision")
    private Prevision prevision;

    public Paciente(String run, String nombre, String apellido,
                    LocalDate fechaNacimiento, String correo,
                    String telefono, Prevision prevision) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.prevision = prevision;
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}