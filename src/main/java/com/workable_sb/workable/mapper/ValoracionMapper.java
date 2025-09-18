package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.ValoracionDto;
import com.workable_sb.workable.models.Valoracion;

public interface ValoracionMapper {
  Valoracion consult(ValoracionDto valoracionDto);
  ValoracionDto consultDto(Valoracion entity);
}
