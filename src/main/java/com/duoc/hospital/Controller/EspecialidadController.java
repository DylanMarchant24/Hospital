package com.duoc.hospital.Controller;
import com.duoc.hospital.Model.Especialidad;
import com.duoc.hospital.Service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/especialidad")

public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @RequestMapping
    public ResponseEntity<List<Especialidad>> Listar() {
        List<Especialidad> especialidad = especialidadService.findAll();
        if (especialidad.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(especialidad);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> Buscar(@PathVariable Integer id) {
        Optional<Especialidad> especialidad = especialidadService.findById(id);
        return especialidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Especialidad> guardar(@RequestBody Especialidad especialidad) {
        Especialidad newespecialidad = especialidadService.save(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(newespecialidad);
    }
}
