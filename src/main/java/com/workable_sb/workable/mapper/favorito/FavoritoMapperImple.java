package com.workable_sb.workable.mapper.favorito;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.favorito.FavoritoDto;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.models.Favorito;
import com.workable_sb.workable.models.FavoritoId;
import com.workable_sb.workable.models.Oferta;
import com.workable_sb.workable.repositories.AspiranteRepository;

import com.workable_sb.workable.repositories.OfertaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class FavoritoMapperImple implements FavoritoMapper{

  private AspiranteRepository aspiranteRepository;
  private OfertaRepository ofertaRepository;

  public FavoritoMapperImple(AspiranteRepository aspiranteRepository, OfertaRepository ofertaRepository) {
    this.aspiranteRepository = aspiranteRepository;
    this.ofertaRepository = ofertaRepository;
  }

  @Override
  public Favorito toEntity(FavoritoDto dto) {
    Aspirante aspirante = aspiranteRepository.findById(dto.getAspId())
    .orElseThrow(() -> new  EntityNotFoundException("Aspirante no encontrado"));

    Oferta oferta = ofertaRepository.findById(dto.getOfeId())
    .orElseThrow(() -> new EntityNotFoundException("Oferta no encontrada"));

    FavoritoId id = new FavoritoId(aspirante.getAspiranteId(), oferta.getOfertaId());

    Favorito favorito = new Favorito();
    favorito.setId(id);
    favorito.setAspirante(aspirante);
    favorito.setOferta(oferta);

    return favorito;
  }

  @Override
  public FavoritoDto toDto(Favorito entity) {
    FavoritoDto dto = new FavoritoDto();

    dto.setAspId(entity.getAspirante().getAspiranteId());
    dto.setOfeId(entity.getOferta().getOfertaId());
    dto.setOfeEmpresa(entity.getOferta().getEmpresa().getNombre());
    dto.setOfeTitu(entity.getOferta().getTitulo());

    return dto;
  }
}
