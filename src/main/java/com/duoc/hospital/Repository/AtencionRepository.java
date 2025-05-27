package com.duoc.hospital.Repository;

import com.duoc.hospital.Model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findByFechaAtencion(LocalDate fechaAtencion);
    List<Atencion> findByFechaAtencionBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Atencion> findByCostoLessThan(double costoMaximo);
    List<Atencion> findByCostoGreaterThan(double costoMinimo);
    @Query("SELECT a FROM Atencion a WHERE a.medico.id_medico = :id")
    List<Atencion> findByMedicoId(@Param("id") int id);
    @Query("SELECT a FROM Atencion a WHERE a.paciente.id_paciente = :id")
    List<Atencion> findByPacienteId(@Param("id") int id);
    @Query("SELECT SUM(a.costo) FROM Atencion a WHERE a.estado = 'Alta'")
    Integer sumCostoByEstadoAlta();
    List<Atencion> findByEstado(String estado);
}
