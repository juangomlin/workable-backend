package com.workable_sb.workable.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.ValoracionDto;
import com.workable_sb.workable.models.Empresa;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.models.Valoracion;
import com.workable_sb.workable.repositories.EmpresaRepository;
import com.workable_sb.workable.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ValoracionMapperImple implements ValoracionMapper {

  private final EmpresaRepository empresaRepository;
  private final UsuarioRepository usuarioRepository;

  public ValoracionMapperImple(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository){
    this.empresaRepository = empresaRepository;
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public Valoracion consult(ValoracionDto valoracionDto){
  Valoracion valoracion = new Valoracion();
  valoracion.setValoracion_id(valoracionDto.getId());
  valoracion.setDescripcion(valoracionDto.getDesc());
  valoracion.setPuntuacion(valoracionDto.getPunt());
  valoracion.setFecha_valoracion(valoracionDto.getFeVa());

  Empresa empresa = empresaRepository.findById(valoracionDto.getEmpresa_id())
  .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
  valoracion.setEmpresa(empresa);

  Usuario usuario = usuarioRepository.findById(valoracionDto.getUsuario_id())
  .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
  valoracion.setUsuario(usuario);

  return valoracion;
  }

  @Override
  public ValoracionDto consultDto(Valoracion entity){
    return new ValoracionDto(
    entity.getValoracion_id(),
    entity.getDescripcion(),
    entity.getPuntuacion(),
    entity.getFecha_valoracion(),
    entity.getEmpresa().getEmpresa_id(),
    entity.getEmpresa().getNombre(),
    entity.getUsuario().getUsuario_id(),
    entity.getUsuario().getNombre());
  }
}
