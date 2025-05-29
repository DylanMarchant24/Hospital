package com.duoc.hospital.Controller;
import com.duoc.hospital.Model.Atencion;
import com.duoc.hospital.Model.Medico;
import com.duoc.hospital.Model.Paciente;
import com.duoc.hospital.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.duoc.hospital.Service.AtencionService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    @Autowired
    private AtencionService atencionservice;

    @RequestMapping
    public ResponseEntity<List<Medico>> Listar() {
        List<Medico> medicos = medicoService.findAll();
        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> Buscar(@PathVariable Integer id) {
        Optional<Medico> medico = medicoService.findById(id);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> guardar(@RequestBody Medico medico) {
        Medico newMedico = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMedico);
    }

    @GetMapping("/BUSCAR")
    public ResponseEntity<List<Medico>> buscarnombreapellido(@RequestParam String nombre ,@RequestParam String apellido) {
        List<Medico> medicos = medicoService.findNombreAndApellido(nombre, apellido);
        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/BUSCARRUN")
    public ResponseEntity<List<Medico>> finByRun(@RequestParam String run ) {
        List<Medico> medicos = medicoService.findByRun(run);
        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/antiguedad")
    public List<Medico> obtenerMedicosConAntiguedadMenor(@RequestParam int anios) {
        return medicoService.obtenerMedicosConMenosDeNAnios(anios);
    }

    @GetMapping("/antiguedad/mayor")
    public List<Medico> obtenerMedicosConAntiguedadMayor(@RequestParam int anios) {
        return medicoService.obtenerMedicosConMasDeNAnios(anios);
    }

    @GetMapping("/atenciones/medico/{id}")
    public ResponseEntity<List<Atencion>> getAtencionesPorMedico(@PathVariable int id) {
        List<Atencion> atenciones = atencionservice.findByMedicoId(id);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }
    @GetMapping("/{id}/sueldo-total")
    public ResponseEntity<Integer> getSueldoTotalMedico(@PathVariable int id) {
        Integer sueldoTotal = medicoService.calcularSueldoTotal(id);
        return ResponseEntity.ok(sueldoTotal);
    }
}