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

  private final AspiranteRepository usuarioRepository;
  private final AspiranteMapper usuarioMapper;

  public AspiranteServiceImple(AspiranteRepository usuarioRepository, AspiranteMapper usuarioMapper){
    this.usuarioRepository = usuarioRepository;
    this.usuarioMapper = usuarioMapper;
  }

  @Override
  public AspiranteDto guardar(AspiranteDto usuarioDto){
    Aspirante usuario = usuarioMapper.consult(usuarioDto);
    Aspirante guardado = usuarioRepository.save(usuario);
    return usuarioMapper.consultDto(guardado);
  }

  @Override
  public AspiranteDto listId(Integer id){
    return usuarioRepository.findById(id)
      .map(usuarioMapper::consultDto)
      .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
  }

  @Override
  public List<AspiranteDto> listarAll(){
    return usuarioRepository.findAll()
    .stream()
    .map(usuarioMapper:: consultDto)
    .collect(Collectors.toList());
  }

  @Override
  public void eliminar(Integer id){
    usuarioRepository.deleteById(id);
  }
  
}
