package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.mapper.UsuarioMapper;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImple implements UsuarioService{

  private final UsuarioRepository usuarioRepository;
  private final UsuarioMapper usuarioMapper;

  public UsuarioServiceImple(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper){
    this.usuarioRepository = usuarioRepository;
    this.usuarioMapper = usuarioMapper;
  }

  @Override
  public UsuarioDto guardar(UsuarioDto usuarioDto){
    Usuario usuario = usuarioMapper.consult(usuarioDto);
    Usuario guardado = usuarioRepository.save(usuario);
    return usuarioMapper.consultDto(guardado);
  }

  @Override
  public UsuarioDto listId(Integer id){
    return usuarioRepository.findById(id)
      .map(usuarioMapper::consultDto)
      .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
  }

  @Override
  public List<UsuarioDto> listarAll(){
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
