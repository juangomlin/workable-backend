package com.workable_sb.workable.service.favorito;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.favorito.FavoritoDto;
import com.workable_sb.workable.mapper.favorito.FavoritoMapper;
import com.workable_sb.workable.models.Favorito;
import com.workable_sb.workable.models.FavoritoId;
import com.workable_sb.workable.repositories.FavoritoRepository;

@Service
public class FavoritoServiceImple implements FavoritoService{

  private final FavoritoMapper mapper;
  private final FavoritoRepository repository;

  public FavoritoServiceImple(FavoritoMapper mapper, FavoritoRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public void add(FavoritoDto dto) {
    Favorito entity = mapper.toEntity(dto);
    if (repository.existsById(entity.getId())) {
      throw new IllegalStateException("Ya existe esta relaion Aspirante-Oferta");
    }
    repository.save(entity);
  }

  @Override
  public void delete(FavoritoDto dto) {
    FavoritoId id = new FavoritoId(dto.getAspId(), dto.getOfeId());
    repository.deleteById(id);
  }

  @Override
  public List<FavoritoDto> listAll(Integer aspId) {
    List<FavoritoDto> favoritos = repository.findById_AspiranteId(aspId)
    .stream()
    .map(mapper::toDto)
    .collect(Collectors.toList()); 

    return favoritos;
  }
}
