package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.OfertaBeneficioDto;
import com.workable_sb.workable.models.Beneficio;
import com.workable_sb.workable.models.Oferta;
import com.workable_sb.workable.models.OfertaBeneficio;
import com.workable_sb.workable.models.OfertaBeneficioId;
import com.workable_sb.workable.repositories.BeneficioRepository;
import com.workable_sb.workable.repositories.OfertaBeneficioRepository;
import com.workable_sb.workable.repositories.OfertaRepository;

import jakarta.persistence.EntityNotFoundException;

public class OfertaBeneficioMapperImple implements OfertaBeneficioMapper{
  private final OfertaRepository ofertaRepository;
  private final BeneficioRepository beneficioRepository;

  public OfertaBeneficioMapperImple (OfertaRepository ofertaRepository, BeneficioRepository beneficioRepository) {
    this.ofertaRepository = ofertaRepository;
    this.beneficioRepository = beneficioRepository;
  }

  @Override
  public OfertaBeneficio consultEntity(OfertaBeneficioDto dto) {

    Oferta oferta = ofertaRepository.findById(dto.getOfeId()).orElseThrow(() -> new EntityNotFoundException("oferta no encontrada"));

    Beneficio beneficio = beneficioRepository.findById(dto.getBeneId()).orElseThrow(() -> new EntityNotFoundException("beneficio no encontrado"));

    OfertaBeneficioId id = new OfertaBeneficioId(dto.getOfeId(), dto.getBeneId());

    OfertaBeneficio entity = new OfertaBeneficio();
    entity.setId(id);
    entity.setOferta(oferta);
    entity.setBeneficio(beneficio);

    return entity;
  }

  @Override
  public OfertaBeneficioDto consultDto(OfertaBeneficio entity) {
    return new OfertaBeneficioDto(
      entity.getOferta().getOfertaId(),
      entity.getOferta().getTitulo(),
      entity.getBeneficio().getBeneficioId(),
      entity.getBeneficio().getNombre()
    );
  }
}
