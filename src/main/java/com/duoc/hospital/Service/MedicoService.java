package com.duoc.hospital.Service;



import com.duoc.hospital.Model.Medico;
import com.duoc.hospital.Model.Paciente;
import com.duoc.hospital.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    /*GET, GETBYID, GUARDAR, ACTUALIZAR, BORRAR */

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(int id) {
        return medicoRepository.findById(id);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(int id) {
        medicoRepository.deleteById(id);
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public List<Medico> findNombreAndApellido(String nombre, String apellido) {
        return medicoRepository.findByNombreAndApellido(nombre, apellido);
    }

    public List<Medico> findByRun(String run) {
        return medicoRepository.findByRun(run);
    }

    public List<Medico> obtenerMedicosConMenosDeNAnios(int n) {
        LocalDate fechaLimite = LocalDate.now().minusYears(n);
        return medicoRepository.findByFechaContratoAfter(fechaLimite);
    }

    public List<Medico> obtenerMedicosConMasDeNAnios(int n) {
        LocalDate fechaLimite = LocalDate.now().minusYears(n);
        return medicoRepository.findByFechaContratoBefore(fechaLimite);
    }

    public Integer calcularSueldoTotal(int idMedico) {
        Optional<Medico> medicoOpt = medicoRepository.findById(idMedico);
        if (medicoOpt.isEmpty()) return 0;

        Double comision = medicoRepository.findComisionPorAtenciones(idMedico);
        int sueldoBase = medicoOpt.get().getSueldo_base();

        return (int) (sueldoBase + (comision != null ? comision : 0));
    }
}