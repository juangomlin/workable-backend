package com.workable_sb.workable.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.AspiranteAsignadoDto;
import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.DiscapacidadAsignadaDto;
import com.workable_sb.workable.dto.RespAsignacionMasivaDTO;
import com.workable_sb.workable.dto.ResultadoAsignacionDTO;
import com.workable_sb.workable.service.AspiranteDiscapacidadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaciones-discapacidad")
public class AspiranteDiscapacidadController {

    private final AspiranteDiscapacidadService service;

    public AspiranteDiscapacidadController(AspiranteDiscapacidadService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AspiranteDiscapacidadDto> asignar(@Valid @RequestBody AspiranteDiscapacidadDto dto) {
        AspiranteDiscapacidadDto asignado = service.asignar(dto);
        return ResponseEntity.ok(asignado);
    }

    @PostMapping("/varios")
    public ResponseEntity<List<ResultadoAsignacionDTO>> asignarVariosNormal(
            @RequestBody List<AspiranteDiscapacidadDto> asignaciones) {
        List<ResultadoAsignacionDTO> resultados = service.asignarVariosNormal(asignaciones);
        return ResponseEntity.ok(resultados);
    }

    @PostMapping("/varios2")
    public ResponseEntity<RespAsignacionMasivaDTO> asignarVarios(
            @RequestBody List<AspiranteDiscapacidadDto> asignaciones) {
        RespAsignacionMasivaDTO response = service.asignarVarios(asignaciones);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/aspirante/{id}")
    public ResponseEntity<List<AspiranteDiscapacidadDto>> listarPorAspirante(@PathVariable Integer id) {
        List<AspiranteDiscapacidadDto> asignaciones = service.listarPorAspirante(id);
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/aspirante2/{id}")
    public ResponseEntity<List<AspiranteAsignadoDto>> listarPorAspirante2(@PathVariable Integer id) {
        List<AspiranteAsignadoDto> discapacidades = service.listarPorAspirante2(id);
        return ResponseEntity.ok(discapacidades);
    }

    @GetMapping("/discapacidad/{id}")
    public ResponseEntity<List<AspiranteDiscapacidadDto>> listarPorDiscapacidad(@PathVariable Short id) {
        List<AspiranteDiscapacidadDto> asignaciones = service.listarPorDiscapacidad(id);
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/discapacidad2/{id}")
    public ResponseEntity<List<DiscapacidadAsignadaDto>> listarPorDiscapacidad2(@PathVariable Short id) {
        List<DiscapacidadAsignadaDto> aspirantes = service.listarPorDiscapacidad2(id);
        return ResponseEntity.ok(aspirantes);
    }

    @DeleteMapping("/{aspiranteId}/{discapacidadId}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer aspiranteId, @PathVariable Short discapacidadId) {
        service.eliminarAsignacion(aspiranteId, discapacidadId);
        return ResponseEntity.noContent().build();
    }

}
