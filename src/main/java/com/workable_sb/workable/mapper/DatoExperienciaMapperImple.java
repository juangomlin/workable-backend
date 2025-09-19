package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.DatoExperienciaDto;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.models.DatoExperiencia;
import com.workable_sb.workable.repositories.AspiranteRepository;


import jakarta.persistence.EntityNotFoundException;

@Component
public class DatoExperienciaMapperImple implements DatoExperienciaMapper {

    private final AspiranteRepository aspiranteRepository;

    public DatoExperienciaMapperImple(AspiranteRepository usuarioRepository) {
        this.aspiranteRepository = usuarioRepository;
    }

    @Override
    public DatoExperiencia consult(DatoExperienciaDto datoExperienciaDto) {
        DatoExperiencia datoExperiencia = new DatoExperiencia();
        datoExperiencia.setExperiencia_id(datoExperienciaDto.getExp_id());
        datoExperiencia.setCargo(datoExperienciaDto.getCarg());
        datoExperiencia.setEmpresa(datoExperienciaDto.getEmpr());
        datoExperiencia.setFechaInicio(datoExperienciaDto.getFechaIn());
        datoExperiencia.setFechaFin(datoExperienciaDto.getFechaFi());
        datoExperiencia.setUbicacion(datoExperienciaDto.getUbicacion());

        if (datoExperienciaDto.getUsr_id() != null) {
            Aspirante aspirante = aspiranteRepository.findById(datoExperienciaDto.getUsr_id())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + datoExperienciaDto.getUsr_id()));
            datoExperiencia.setUsuario(aspirante);
        } else {
            datoExperiencia.setUsuario(null);
        }

        return datoExperiencia;
    }

    @Override
    public DatoExperienciaDto consultDto(DatoExperiencia entity) {
    return new DatoExperienciaDto(
            entity.getExperiencia_id(),
            entity.getCargo(),
            entity.getEmpresa(),
            entity.getFechaInicio(),
            entity.getFechaFin(),
            entity.getUbicacion(),
            entity.getUsuario().getAspirante_id(),
            entity.getUsuario().getNombre());
    }
}
