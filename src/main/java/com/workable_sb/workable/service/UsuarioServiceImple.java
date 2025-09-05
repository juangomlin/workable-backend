package com.workable_sb.workable.service;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.mapper.UsuarioMapper;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.UsuarioRepository;

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

}
