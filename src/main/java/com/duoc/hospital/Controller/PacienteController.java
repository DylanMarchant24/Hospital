package com.duoc.hospital.Controller;
import com.duoc.hospital.Service.PacienteService;
import com.duoc.hospital.Model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> Listar() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> Buscar(@PathVariable Integer id) {
        Optional<Paciente> paciente = pacienteService.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
    }

    @GetMapping("/BUSCAR")
    public ResponseEntity<List<Paciente>> buscarnombreapellido(@RequestParam String nombre ,@RequestParam String apellido) {
        List<Paciente> pacientes = pacienteService.findNombreAndApellido(nombre, apellido);
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/BUSCARNOMBRE")
    public ResponseEntity<List<Paciente>> buscarnombre(@RequestParam String nombre ) {
        List<Paciente> pacientes = pacienteService.finByPrevisionNombre(nombre);
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/BUSCARRUN")
    public ResponseEntity<List<Paciente>> finByRun(@RequestParam String run ) {
        List<Paciente> pacientes = pacienteService.finByRun(run);
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/menores-de/{edad}")
    public List<Paciente> obtenerPacientesMenoresDe(@PathVariable int edad) {
        return pacienteService.obtenerPacientesMenoresDe(edad);
    }

    @GetMapping("/mayores-de/{edad}")
    public List<Paciente> obtenerPacientesMayoresDe(@PathVariable int edad) {
        return pacienteService.obtenerPacientesMayoresDe(edad);
    }
}