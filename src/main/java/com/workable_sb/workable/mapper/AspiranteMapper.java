package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.AspiranteDto;
import com.workable_sb.workable.models.Aspirante;

public interface AspiranteMapper {
  Aspirante consult(AspiranteDto aspiranteDto);
  AspiranteDto consultDto(Aspirante entity);
}
