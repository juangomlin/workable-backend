package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.AspiranteAsignadoDto;
import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.DiscapacidadAsignadaDto;
import com.workable_sb.workable.models.AspiranteDiscapacidad;

public interface AspiranteDiscapMapper {
  AspiranteDiscapacidad consult(AspiranteDiscapacidadDto dto);
  AspiranteDiscapacidadDto consultDto(AspiranteDiscapacidad entity);
  AspiranteAsignadoDto consultAsignadoAspirante(AspiranteDiscapacidad entity);
  DiscapacidadAsignadaDto consultAsignadoDiscapacidad(AspiranteDiscapacidad entity);
}
