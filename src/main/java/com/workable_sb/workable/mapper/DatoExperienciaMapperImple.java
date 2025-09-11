package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.DatoExperienciaDto;
import com.workable_sb.workable.models.DatoExperiencia;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.DatoExperienciaRepository;
import com.workable_sb.workable.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class DatoExperienciaMapperImple {

    private final DatoExperienciaRepository datoExperienciaRepository;
    private final UsuarioRepository usuarioRepository;

    public DatoExperienciaMapperImple(DatoExperienciaRepository datoExperienciaRepository, UsuarioRepository usuarioRepository) {
        this.datoExperienciaRepository = datoExperienciaRepository;
        this.usuarioRepository = usuarioRepository;
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

        Usuario usuario = usuarioRepository.findById(datoExperienciaDto.getUsr_id())
                .orElseThrow(() -> new EntityNotFoundException("Cargo no encontrado"));
        datoExperiencia.setUsuario(usuario); 
    }

    @Override   
    public DatoExperienciaDto consulDto(DatoExperienciaDto entity) {
        return new DatoExperienciaDto(
         
    }
}
