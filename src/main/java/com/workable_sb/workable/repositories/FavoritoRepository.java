package com.workable_sb.workable.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.Favorito;
import com.workable_sb.workable.models.FavoritoId;

public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId>{
  List<Favorito> findById_AspiranteId(Integer aspId);
}
