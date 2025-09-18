package com.workable_sb.workable.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.ReclutadorDto;
import com.workable_sb.workable.service.ReclutadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reclutadores")
public class ReclutadorController {

    private final ReclutadorService reclutadorService;

    public ReclutadorController(ReclutadorService reclutadorService) {
        this.reclutadorService = reclutadorService;
    }

    @PostMapping
    public ResponseEntity<ReclutadorDto> crearyupdate(@Valid @RequestBody ReclutadorDto reclutadorDto) {
        ReclutadorDto crear = reclutadorService.crearyupdate(reclutadorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(crear);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReclutadorDto> obtenerPorId(@PathVariable Integer reclutador_id) {
        ReclutadorDto obtener = reclutadorService.buscarPorId(reclutador_id);
        return ResponseEntity.ok(obtener);
    }

    @GetMapping
    public ResponseEntity<List<ReclutadorDto>> listarTodos() {
        List<ReclutadorDto> reclutador = reclutadorService.listarTodos();
        return ResponseEntity.ok(reclutador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer reclutador_id) {
        reclutadorService.eliminar(reclutador_id);
        return ResponseEntity.noContent().build();}
}
