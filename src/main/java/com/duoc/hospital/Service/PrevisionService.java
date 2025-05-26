package com.duoc.hospital.Service;


import com.duoc.hospital.Model.Prevision;
import com.duoc.hospital.Repository.PrevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrevisionService {

    @Autowired
    private PrevisionRepository previsionRepository;

    public List<Prevision> getAllPrevision() {
        return previsionRepository.findAll();
    }

    public Optional<Prevision> findById(int id) {
        return previsionRepository.findById(id);
    }

    public Prevision save(Prevision prevision) {
        return previsionRepository.save(prevision);
    }

    public void deleteById(int id) {
        previsionRepository.deleteById(id);
    }

    public List<Prevision> findAll() {
        return previsionRepository.findAll();
    }
}
