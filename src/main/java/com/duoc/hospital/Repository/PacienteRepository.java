package com.duoc.hospital.Repository;

import com.duoc.hospital.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

    List<Paciente>findByNombreAndApellido(String nombre,String apellido);

    List<Paciente>finByPrevisionNombre(String nombre);

    List<Paciente>finByRun(String run);

    List<Paciente> findByEdadLessThan(int edad);

    List<Paciente> findByEdadGreaterThan(int edad);
}
