package com.duoc.hospital.Repository;

import com.duoc.hospital.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findByNombreAndApellido(String nombre, String apellido);

    List<Medico>findByRun(String run);

    List<Medico> findByFechaContratoAfter(LocalDate fechaLimite);

    List<Medico> findByFechaContratoBefore(LocalDate fechaLimite);
    @Query("SELECT SUM(a.costo * 0.2) FROM Atencion a WHERE a.medico.id_medico = :id")
    Double findComisionPorAtenciones(@Param("id") int id);
}
