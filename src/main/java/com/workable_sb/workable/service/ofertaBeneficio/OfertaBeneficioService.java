package com.workable_sb.workable.service.ofertaBeneficio;

import java.util.List;

import com.workable_sb.workable.dto.beneficio.BeneficioAssignDto;
import com.workable_sb.workable.dto.oferta.OfertaAssignDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenMassResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfertaBeneficioDto;

public interface OfertaBeneficioService {
  OfertaBeneficioDto assign(OfertaBeneficioDto asignacion);

  List<OfertaBeneficioDto> listByOferta(Integer ofertaId);
  List<OfertaAssignDto> listByOferta2(Integer ofertaId);

  List<OfertaBeneficioDto> listByBeneficio(Short beneficioId);
  List<BeneficioAssignDto> listByBeneficio2(Short beneficioId);

  void deleteAssign(Integer ofertaId, Short beneficioId);

  OfeBenMassResultDto massAssign(List<OfertaBeneficioDto> asignaciones);
  List<OfeBenResultDto> massAssign2(List<OfertaBeneficioDto> asigaciones);
}
