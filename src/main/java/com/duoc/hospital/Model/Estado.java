package com.duoc.hospital.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Estado")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Estado {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_estado;

        @Column(nullable = false, length = 50)
        private String nombre;

        @Column(nullable = false, length = 200)
        private String descripcion;


        public Estado(String nombre, String descripcion) {
                this.nombre = nombre;
                this.descripcion = descripcion;
        }
}
