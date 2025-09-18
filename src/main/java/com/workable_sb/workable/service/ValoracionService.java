package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.ValoracionDto;

public interface ValoracionService {
  ValoracionDto crear(ValoracionDto valoracionDto);
  ValoracionDto listarId(Integer id);
  List<ValoracionDto> listarAll();
  void eliminar(Integer id);
}
