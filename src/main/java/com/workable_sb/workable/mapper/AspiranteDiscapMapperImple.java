package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.models.AspiranteDiscapacidad;
import com.workable_sb.workable.models.AspiranteDiscapacidadId;
import com.workable_sb.workable.models.Discapacidad;
import com.workable_sb.workable.repositories.AspiranteRepository;
import com.workable_sb.workable.repositories.DiscapacidadRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Null;

@Component
public class AspiranteDiscapMapperImple implements AspiranteDiscapMapper{

  private final AspiranteRepository aspiranteRepository;
  private final DiscapacidadRepository discapacidadRepository;

  public AspiranteDiscapMapperImple(AspiranteRepository aspiranteRepository, DiscapacidadRepository discapacidadRepository){
    this.aspiranteRepository = aspiranteRepository;
    this.discapacidadRepository = discapacidadRepository;
  }

  @Override


  public AspiranteDiscapacidad consult(AspiranteDiscapacidadDto dto) {
        Aspirante aspirante = aspiranteRepository.findById(dto.getAspi_id())
                .orElseThrow(() -> new EntityNotFoundException("Aspirante no encontrado"));

        Discapacidad discapacidad = discapacidadRepository.findById(dto.getDisc_id())
                .orElseThrow(() -> new EntityNotFoundException("Discapacidad no encontrada"));

        AspiranteDiscapacidadId id = new AspiranteDiscapacidadId(dto.getAspi_id(), dto.getDisc_id());

        AspiranteDiscapacidad relacion = new AspiranteDiscapacidad();
        relacion.setId(id);
        relacion.setAspirante(aspirante);
        relacion.setDiscapacidad(discapacidad);

        return relacion;
    }

    @Override
    public AspiranteDiscapacidadDto consultDto(AspiranteDiscapacidad entity) {
        AspiranteDiscapacidadDto dto = new AspiranteDiscapacidadDto();
        dto.setAspi_id(entity.getAspirante().getAspirante_id());
        dto.setNom_aspi(entity.getAspirante().getNombre());
        dto.setNom_dis(entity.getDiscapacidad().getNombre());
        dto.setDisc_id(entity.getDiscapacidad().getDiscapacidad_id());
        return dto;
    }

}
