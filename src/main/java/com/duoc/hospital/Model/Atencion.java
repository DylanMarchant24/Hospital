package com.duoc.hospital.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "Atencion")
@AllArgsConstructor
@NoArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_atencion;

    @Column(nullable = false)
    private LocalDate fecha_atencion;

    @Column(nullable = false)
    private double cobertura; // Porcentaje cubierto por previsión

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(columnDefinition = "integer default 0", length = 10)
    private int costo;

    @Column(nullable = false, length = 300)
    private String comentario;

    @Column(nullable = false, length = 20)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    public Atencion(LocalDate parse, LocalTime parse1, int i, String s, String nombre, Paciente paciente1, Medico medico1) {
    }
}
