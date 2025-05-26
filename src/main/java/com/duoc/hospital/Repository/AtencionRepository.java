package com.duoc.hospital.Repository;

import com.duoc.hospital.Model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {

    List<Atencion> findByFechaAtencion(LocalDate fechaAtencion);

    List<Atencion> findByFechaAtencionBetween(LocalDate fechaInicio, LocalDate fechaFin);

    List<Atencion> findByCostoLessThan(double costoMaximo);

    List<Atencion> findByCostoGreaterThan(double costoMinimo);
}
