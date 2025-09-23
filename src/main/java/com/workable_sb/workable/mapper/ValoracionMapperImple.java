package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.ValoracionDto;
import com.workable_sb.workable.models.Empresa;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.models.Valoracion;
import com.workable_sb.workable.repositories.EmpresaRepository;
import com.workable_sb.workable.repositories.AspiranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ValoracionMapperImple implements ValoracionMapper {

  private final EmpresaRepository empresaRepository;
  private final AspiranteRepository aspiranteRepository;

  public ValoracionMapperImple(EmpresaRepository empresaRepository, AspiranteRepository aspiranteRepository){
    this.empresaRepository = empresaRepository;
    this.aspiranteRepository = aspiranteRepository;
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

  Aspirante aspirante = aspiranteRepository.findById(valoracionDto.getAspirante_id())
  .orElseThrow(() -> new EntityNotFoundException("Aspirante no encontrado"));
  valoracion.setAspirante(aspirante);;

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
    entity.getAspirante().getAspirante_id(),
    entity.getAspirante().getNombre()
    );
  }
}
