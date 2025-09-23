package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.AspiranteDto;
import com.workable_sb.workable.dto.AspiranteReadDto;
import com.workable_sb.workable.mapper.AspiranteMapper;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.repositories.AspiranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AspiranteServiceImple implements AspiranteService{

  private final AspiranteRepository aspiranteRepository;
  private final AspiranteMapper aspiranteMapper;

  public AspiranteServiceImple(AspiranteRepository aspiranteRepository, AspiranteMapper aspiranteMapper){
    this.aspiranteRepository = aspiranteRepository;
    this.aspiranteMapper = aspiranteMapper;
  }

  @Override
  public AspiranteReadDto guardar(AspiranteDto aspiranteDto){
    Aspirante aspirante = aspiranteMapper.consult(aspiranteDto);
    Aspirante guardado = aspiranteRepository.save(aspirante);
    return aspiranteMapper.consultReadDto(guardado);
  }

  @Override
  public AspiranteReadDto listId(Integer id){
    return aspiranteRepository.findById(id)
      .map(aspiranteMapper::consultReadDto)
      .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
  }

  @Override
  public List<AspiranteReadDto> listarAll(){
    return aspiranteRepository.findAll()
    .stream()
    .map(aspiranteMapper:: consultReadDto)
    .collect(Collectors.toList());
  }

  @Override
    public void eliminar(Integer id) {
      Aspirante aspirante = aspiranteRepository.findById(id)
          .orElseThrow(() -> new EntityNotFoundException("Aspirante no encontrado"));
      aspiranteRepository.delete(aspirante);
  }

}
