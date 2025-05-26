package com.duoc.hospital.Service;


import com.duoc.hospital.Model.Estado;
import com.duoc.hospital.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> getAllEstado() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> findById(int id) {
        return estadoRepository.findById(id);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void deleteById(int id) {
        estadoRepository.deleteById(id);
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }
}
