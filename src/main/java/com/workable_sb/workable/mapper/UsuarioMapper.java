package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.models.Usuario;

public interface UsuarioMapper {
  Usuario consult(UsuarioDto usuarioDto);
  UsuarioDto consultDto(Usuario entity);
}
