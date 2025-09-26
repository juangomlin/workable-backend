package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.models.AspiranteDiscapacidad;

public interface AspiranteDiscapMapper {
  AspiranteDiscapacidad consult(AspiranteDiscapacidadDto dto);
  AspiranteDiscapacidadDto consultDto(AspiranteDiscapacidad entity);
}
