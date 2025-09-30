package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.OfertaBeneficioDto;
import com.workable_sb.workable.models.OfertaBeneficio;

public interface OfertaBeneficioMapper {
  OfertaBeneficio consultEntity(OfertaBeneficioDto dto);
  OfertaBeneficioDto consultDto(OfertaBeneficio entity);
  OfertaBeneficioDto consultByBeneficio(OfertaBeneficio entity);
  OfertaBeneficioDto consultByOferta(OfertaBeneficio entity);
}
