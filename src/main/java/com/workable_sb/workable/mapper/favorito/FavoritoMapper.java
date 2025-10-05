package com.workable_sb.workable.mapper.favorito;

import com.workable_sb.workable.dto.favorito.FavoritoDto;
import com.workable_sb.workable.models.Favorito;

public interface FavoritoMapper {
  Favorito toEntity(FavoritoDto dto);
  FavoritoDto toDto(Favorito entity);
}
