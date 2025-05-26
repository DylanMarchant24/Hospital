package com.duoc.hospital.Repository;

import com.duoc.hospital.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findByNombreAndApellido(String nombre, String apellido);

    List<Medico>finByRun(String run);

    List<Medico> findByFechaContratacionAfter(LocalDate fechaLimite);

    List<Medico> findByFechaContratacionBefore(LocalDate fechaLimite);
}
