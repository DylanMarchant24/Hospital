package com.duoc.hospital.Controller;


import com.duoc.hospital.Model.Estado;
import com.duoc.hospital.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping
    public ResponseEntity<List<Estado>> Listar() {
        List<Estado> estado = estadoService.findAll();
        if (estado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(estado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> Buscar(@PathVariable Integer id) {
        Optional<Estado> estado = estadoService.findById(id);
        return estado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado){
        Estado newEstado = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEstado);
    }
}
