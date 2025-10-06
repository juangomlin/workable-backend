package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.favorito.FavoritoDto;
import com.workable_sb.workable.service.favorito.FavoritoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/favorito")
public class FavoritoController {
  private final FavoritoService service;

  public FavoritoController(FavoritoService service) {
    this.service = service;
  }

  @GetMapping("/{aspId}")
  public ResponseEntity<List<FavoritoDto>> listAll(@PathVariable Integer aspId) {
    List<FavoritoDto> favoritos = service.listAll(aspId);
    return ResponseEntity.ok(favoritos);
  }
  
  @PostMapping
  public ResponseEntity<Void> add(@Valid @RequestBody FavoritoDto dto) {
    service.add(dto);
    return ResponseEntity.noContent().build();
  }
  
  @DeleteMapping
  public ResponseEntity<Void> delete(@Valid @RequestBody FavoritoDto dto) {
    service.delete(dto);
    return ResponseEntity.noContent().build();
  }
}
