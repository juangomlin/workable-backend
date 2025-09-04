package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

  private final UsuarioService usuarioService;

      public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
  }
   @PostMapping
    public ResponseEntity<UsuarioDto> guardar(@Valid @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto guardado = usuarioService.guardar(usuarioDto);
        return ResponseEntity.ok(guardado);
    }
}
