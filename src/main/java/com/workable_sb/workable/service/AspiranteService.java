package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.AspiranteDto;

public interface AspiranteService {
  AspiranteDto guardar(AspiranteDto usuarioDto);
  AspiranteDto listId(Integer id);
  List<AspiranteDto> listarAll();
  void eliminar(Integer id);
}
