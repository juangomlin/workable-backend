package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.beneficio.BeneficioAssignDto;
import com.workable_sb.workable.dto.oferta.OfertaAssignDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenMassResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfertaBeneficioDto;
import com.workable_sb.workable.service.ofertaBeneficio.OfertaBeneficioService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/OfertaBeneficio")
public class OfertaBeneficioController {
  private final OfertaBeneficioService service;

  public OfertaBeneficioController(OfertaBeneficioService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<OfertaBeneficioDto> assign(@Valid @RequestBody OfertaBeneficioDto dto) {
    OfertaBeneficioDto assigned = service.assign(dto);
    return ResponseEntity.ok(assigned);
  }

  @PostMapping("/varios")
  public ResponseEntity<OfeBenMassResultDto> massAssign(@RequestBody List<OfertaBeneficioDto> assignments) {
    OfeBenMassResultDto results = service.massAssign(assignments);
    return ResponseEntity.ok(results);
  }
  
  @PostMapping("/varios2")
  public ResponseEntity<List<OfeBenResultDto>> massAssign2(@RequestBody List<OfertaBeneficioDto> assignments) {
    List<OfeBenResultDto> results = service.massAssign2(assignments);
    return ResponseEntity.ok(results);
  }
  
  @GetMapping("/oferta/{id}")
  public ResponseEntity<List<OfertaBeneficioDto>> findByOferta(@PathVariable Integer id) {
    List<OfertaBeneficioDto> results = service.listByOferta(id);
    return ResponseEntity.ok(results);
  }
  
  @GetMapping("/oferta2/{id}")
  public ResponseEntity<List<OfertaAssignDto>> findByOferta2(@PathVariable Integer id) {
    List<OfertaAssignDto> results = service.listByOferta2(id);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/beneficio/{id}")
  public ResponseEntity<List<OfertaBeneficioDto>> findByBeneficio(@PathVariable Integer id) {
    List<OfertaBeneficioDto> results = service.listByBeneficio(id);
    return ResponseEntity.ok(results);
  }
  
    @GetMapping("/beneficio2/{id}")
  public ResponseEntity<List<BeneficioAssignDto>> findByBeneficio2(@PathVariable Integer id) {
    List<BeneficioAssignDto> results = service.listByBeneficio2(id);
    return ResponseEntity.ok(results);
  }

  @DeleteMapping("/{ofertaId}/{beneficioId}") 
  public ResponseEntity<Void> deleteAssign(@PathVariable Integer ofertaId, @PathVariable Integer beneficioId){
    service.deleteAssign(ofertaId, beneficioId);
    return ResponseEntity.noContent().build();
  }
}
