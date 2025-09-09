package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.service.UsuarioService;

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

  @GetMapping("/{id}")
    public ResponseEntity <UsuarioDto> ListId(@PathVariable Integer id) {
      UsuarioDto usuarioDto = usuarioService.listId(id);
        return ResponseEntity.ok(usuarioDto);
  }

  @GetMapping
    public ResponseEntity<List<UsuarioDto>>listarAll(){
      List<UsuarioDto> usuarios = usuarioService.listarAll();
      return ResponseEntity.ok(usuarios);
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
      usuarioService.eliminar(id);
      return ResponseEntity.noContent().build();
    }

}
