package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.AspiranteDto;
import com.workable_sb.workable.service.AspiranteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/aspirante")

public class AspiranteController {

  private final AspiranteService aspiranteService;

      public AspiranteController(AspiranteService aspiranteService) {
        this.aspiranteService = aspiranteService;
  }
  @PostMapping
    public ResponseEntity<AspiranteDto> guardar(@Valid @RequestBody AspiranteDto aspiranteDto) {
        AspiranteDto guardado = aspiranteService.guardar(aspiranteDto);
        return ResponseEntity.ok(guardado);
    }

  @GetMapping("/{id}")
    public ResponseEntity <AspiranteDto> ListId(@PathVariable Integer id) {
      AspiranteDto aspiranteDto = aspiranteService.listId(id);
        return ResponseEntity.ok(aspiranteDto);
  }

  @GetMapping
    public ResponseEntity<List<AspiranteDto>>listarAll(){
      List<AspiranteDto> aspirantes = aspiranteService.listarAll();
      return ResponseEntity.ok(aspirantes);
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
      aspiranteService.eliminar(id);
      return ResponseEntity.noContent().build();
    }

}
