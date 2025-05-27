package com.duoc.hospital.Controller;

import com.duoc.hospital.Model.Atencion;
import com.duoc.hospital.Service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @RequestMapping
    public ResponseEntity<List<Atencion>> Listar() {
        List<Atencion> atencions = atencionService.findAll();
        if (atencions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(atencions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> Buscar(@PathVariable Integer id) {
        Optional<Atencion> atencion = atencionService.findById(id);
        return atencion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        Atencion newAtencion = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAtencion);
    }

    @GetMapping("/buscar")
    public List<Atencion> buscarPorFecha(
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return atencionService.buscarPorFecha(fecha);
    }

    @GetMapping("/buscar-rango")
    public List<Atencion> buscarPorRangoDeFechas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return atencionService.buscarEntreFechas(inicio, fin);
    }

    @GetMapping("/buscar-por-costo")
    public List<Atencion> buscarPorCostoMenorA(@RequestParam("max") double costoMaximo) {
        return atencionService.buscarPorCostoMenorA(costoMaximo);
    }

    @GetMapping("/buscar-por-costo-mayor")
    public List<Atencion> buscarPorCostoMayorA(@RequestParam("min") double costoMinimo) {
        return atencionService.buscarPorCostoMayorA(costoMinimo);
    }
    @GetMapping("/medico/{id}")
    public ResponseEntity<List<Atencion>> getAtencionesPorMedico(@PathVariable int id) {
        List<Atencion> atenciones = atencionService.findByMedicoId(id);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }
    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<Atencion>> getAtencionesPorPaciente(@PathVariable int id) {
        List<Atencion> atenciones = atencionService.findByPacienteId(id);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }
    @GetMapping("/ganancia")
    public ResponseEntity<Integer> getTotalGananciaPorAltas() {
        Integer total = atencionService.calcularTotalPorEstadoAlta();
        return ResponseEntity.ok(total != null ? total : 0);
    }
    @GetMapping("/estado")
    public ResponseEntity<List<Atencion>> getAtencionesPorEstado(@RequestParam String estado) {
        List<Atencion> atenciones = atencionService.findByEstado(estado);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }
    @GetMapping("/paciente/{id}/costo-total")
    public ResponseEntity<Integer> getCostoTotalAPagar(@PathVariable int id) {
        Integer totalNeto = atencionService.calcularTotalNetoPaciente(id);
        return ResponseEntity.ok(totalNeto);
    }
}
