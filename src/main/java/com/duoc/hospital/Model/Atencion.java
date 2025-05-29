package com.duoc.hospital.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate fechaAtencion;

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(columnDefinition = "integer default 0", length = 10)
    private int costo;

    @Column(nullable = false, length = 300)
    private String comentario;

    @Column(nullable = false)
    private double cobertura; // Porcentaje cubierto por previsión

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Atencion(LocalDate fechaAtencion, LocalTime hora_inicio, int costo, String comentario, Estado estado, Paciente paciente, Medico medico) {
        this.fechaAtencion = fechaAtencion;
        this.hora_inicio = hora_inicio;
        this.costo = costo;
        this.comentario = comentario;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
    }
}
