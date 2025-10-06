package com.workable_sb.workable.service.favorito;

import java.util.List;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.favorito.FavoritoDto;

@Component
public interface FavoritoService {
  void add(FavoritoDto dto);
  void delete(FavoritoDto dto);
  List<FavoritoDto> listAll(Integer aspId);
}
