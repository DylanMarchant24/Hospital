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
        return atencionRepository.findByFechaAtencion(fecha);
    }

    public List<Atencion> buscarEntreFechas(LocalDate inicio, LocalDate fin) {
        return atencionRepository.findByFechaAtencionBetween(inicio, fin);
    }

    public List<Atencion> buscarPorCostoMenorA(double costoMaximo) {
        return atencionRepository.findByCostoLessThan(costoMaximo);
    }

    public List<Atencion> buscarPorCostoMayorA(double costoMinimo) {
        return atencionRepository.findByCostoGreaterThan(costoMinimo);
    }
}
