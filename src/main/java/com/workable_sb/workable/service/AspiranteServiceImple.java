package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.AspiranteDto;
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
  public AspiranteDto guardar(AspiranteDto usuarioDto){
    Aspirante usuario = aspiranteMapper.consult(usuarioDto);
    Aspirante guardado = aspiranteRepository.save(usuario);
    return aspiranteMapper.consultDto(guardado);
  }

  @Override
  public AspiranteDto listId(Integer id){
    return aspiranteRepository.findById(id)
      .map(aspiranteMapper::consultDto)
      .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
  }

  @Override
  public List<AspiranteDto> listarAll(){
    return aspiranteRepository.findAll()
    .stream()
    .map(aspiranteMapper:: consultDto)
    .collect(Collectors.toList());
  }

  @Override
  public void eliminar(Integer id){
    aspiranteRepository.deleteById(id);
  }
  
}
