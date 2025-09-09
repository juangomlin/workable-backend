package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.UsuarioDto;

public interface UsuarioService {
  UsuarioDto guardar(UsuarioDto usuarioDto);
  UsuarioDto listId(Integer id);
  List<UsuarioDto> listarAll();
  void eliminar(Integer id);
}
