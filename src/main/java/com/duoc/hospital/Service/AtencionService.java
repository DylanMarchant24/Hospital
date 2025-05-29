package com.duoc.hospital.Service;

import com.duoc.hospital.Model.Atencion;
import com.duoc.hospital.Repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AtencionService  {


    @Autowired
    private AtencionRepository atencionRepository;

    /*GET, GETBYID, GUARDAR, ACTUALIZAR, BORRAR */

    public  List<Atencion> getAllAtencions() {
        return atencionRepository.findAll();
    }

    public Optional<Atencion> findById(int id) {
        return atencionRepository.findById(id);
    }

    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public void deleteById(int id) {
        atencionRepository.deleteById(id);
    }

    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    public List<Atencion> buscarPorFecha(LocalDate fecha) {
        return atencionRepository.findAllByFechaAtencion(fecha);
    }

    public List<Atencion> buscarEntreFechas(LocalDate inicio, LocalDate fin) {
        return atencionRepository.findAllByFechaAtencionBetween(inicio, fin);
    }

    public List<Atencion> buscarPorCostoMenorA(double costoMaximo) {
        return atencionRepository.findAllByCostoLessThan(costoMaximo);
    }

    public List<Atencion> buscarPorCostoMayorA(double costoMinimo) {
        return atencionRepository.findAllByCostoGreaterThan(costoMinimo);
    }
    public List<Atencion> findByMedicoId(int id) {
        return atencionRepository.findByMedicoId(id);
    }
    public List<Atencion> findByPacienteId(int id) {
        return atencionRepository.findByPacienteId(id);
    }
    public Integer calcularTotalPorEstadoAlta() {
        return atencionRepository.sumCostoPorEstado("ALTA");
    }
    public List<Atencion> findAllByEstado(String nombreEstado) {
        return atencionRepository.findByEstadoNombre(nombreEstado);
    }
    public Integer calcularTotalNetoPaciente(int idPaciente) {
        List<Atencion> atenciones = atencionRepository.findByPacienteId(idPaciente);
        return atenciones.stream()
                .mapToInt(a -> (int) (a.getCosto() * (1 - a.getCobertura() / 100.0))) // Aplica descuento por cobertura
                .sum();
    }
}
