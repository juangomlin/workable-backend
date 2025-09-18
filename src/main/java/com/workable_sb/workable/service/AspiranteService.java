package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.AspiranteDto;
import com.workable_sb.workable.dto.AspiranteReadDto;

public interface AspiranteService {
  AspiranteReadDto guardar(AspiranteDto aspiranteDto);
  AspiranteReadDto listId(Integer id);
  List<AspiranteReadDto> listarAll();
  void eliminar(Integer id);
}
