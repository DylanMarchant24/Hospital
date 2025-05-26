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
    private AtencionService atencionservice;

    @RequestMapping
    public ResponseEntity<List<Atencion>> Listar() {
        List<Atencion> atencions = atencionservice.findAll();
        if (atencions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return ResponseEntity.ok(atencions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> Buscar(@PathVariable Integer id) {
        Optional<Atencion> atencion = atencionservice.findById(id);
        return atencion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        Atencion newAtencion = atencionservice.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAtencion);
    }

    @GetMapping("/buscar")
    public List<Atencion> buscarPorFecha(
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return atencionservice.buscarPorFecha(fecha);
    }

    @GetMapping("/buscar-rango")
    public List<Atencion> buscarPorRangoDeFechas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return atencionservice.buscarEntreFechas(inicio, fin);
    }

    @GetMapping("/buscar-por-costo")
    public List<Atencion> buscarPorCostoMenorA(@RequestParam("max") double costoMaximo) {
        return atencionservice.buscarPorCostoMenorA(costoMaximo);
    }

    @GetMapping("/buscar-por-costo-mayor")
    public List<Atencion> buscarPorCostoMayorA(@RequestParam("min") double costoMinimo) {
        return atencionservice.buscarPorCostoMayorA(costoMinimo);
    }
}
