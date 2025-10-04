package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.beneficio.BeneficioAssignDto;
import com.workable_sb.workable.dto.oferta.OfertaAssignDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfertaBeneficioDto;
import com.workable_sb.workable.models.OfertaBeneficio;

public interface OfertaBeneficioMapper {
  OfertaBeneficio toEntity(OfertaBeneficioDto dto);
  OfertaBeneficioDto toDto(OfertaBeneficio entity);
  BeneficioAssignDto consultByBeneficio(OfertaBeneficio entity);
  OfertaAssignDto consultByOferta(OfertaBeneficio entity);
}
