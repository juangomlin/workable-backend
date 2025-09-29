package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.AspiranteAsignadoDto;
import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.DiscapacidadAsignadaDto;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.models.AspiranteDiscapacidad;
import com.workable_sb.workable.models.AspiranteDiscapacidadId;
import com.workable_sb.workable.models.Discapacidad;
import com.workable_sb.workable.repositories.AspiranteRepository;
import com.workable_sb.workable.repositories.DiscapacidadRepository;

import jakarta.persistence.EntityNotFoundException;

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

        AspiranteDiscapacidad aspiranteDiscapacidad = new AspiranteDiscapacidad();
        aspiranteDiscapacidad.setId(id);
        aspiranteDiscapacidad.setAspirante(aspirante);
        aspiranteDiscapacidad.setDiscapacidad(discapacidad);

        return aspiranteDiscapacidad;
    }

    @Override
    public AspiranteDiscapacidadDto consultDto(AspiranteDiscapacidad entity) {
        AspiranteDiscapacidadDto dto = new AspiranteDiscapacidadDto();
        dto.setAspi_id(entity.getAspirante().getAspiranteId());
        dto.setNom_aspi(entity.getAspirante().getNombre());
        dto.setDisc_id(entity.getDiscapacidad().getDiscapacidadId());
        dto.setNom_dis(entity.getDiscapacidad().getNombre());

        return dto;
    }

      @Override
    public AspiranteAsignadoDto consultAsignadoAspirante(AspiranteDiscapacidad entity) {
        AspiranteAsignadoDto dto = new AspiranteAsignadoDto();
        dto.setAspiranteId(entity.getAspirante().getAspiranteId());
        dto.setNombreAspirante(entity.getAspirante().getNombre());

        return dto;
    }

    @Override
    public DiscapacidadAsignadaDto consultAsignadoDiscapacidad(AspiranteDiscapacidad entity) {
        DiscapacidadAsignadaDto dto = new DiscapacidadAsignadaDto();
        dto.setDiscapacidadId(entity.getDiscapacidad().getDiscapacidadId());
        dto.setNombreDiscapacidad(entity.getDiscapacidad().getNombre());
        return dto;
    }

}
