package com.duoc.hospital.Service;
import com.duoc.hospital.Repository.PacienteRepository;
import com.duoc.hospital.Model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    /*GET, GETBYID, GUARDAR, ACTUALIZAR, BORRAR */

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(int id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deleteById(int id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }


    public List<Paciente> findNombreAndApellido(String nombre, String apellido) {
        return pacienteRepository.findByNombreAndApellido(nombre, apellido);
    }

    public List<Paciente> finByPrevisionNombre(String nombre) {
        return pacienteRepository.finByPrevisionNombre(nombre);
    }

    public List<Paciente> finByRun(String run) {
        return pacienteRepository.finByRun(run);
    }

    public List<Paciente> obtenerPacientesMenoresDe(int edad) {
        return pacienteRepository.findByEdadLessThan(edad);
    }

    public List<Paciente> obtenerPacientesMayoresDe(int edad) {
        return pacienteRepository.findByEdadGreaterThan(edad);
    }

    public List<Paciente> findByPrevision(String prevision) {
        return pacienteRepository.findByPrevision(prevision);
    }

    public List<Paciente> findPacientesPorEspecialidadMedico(String especialidad) {
        return pacienteRepository.findPacientesPorEspecialidadMedico(especialidad);
    }
}