package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.DatoExperienciaDto;
import com.workable_sb.workable.models.DatoExperiencia;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class DatoExperienciaMapperImple implements DatoExperienciaMapper {

    private final UsuarioRepository usuarioRepository;

    public DatoExperienciaMapperImple(UsuarioRepository usuarioRepository) {
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

        if (datoExperienciaDto.getUsr_id() != null) {
            Usuario usuario = usuarioRepository.findById(datoExperienciaDto.getUsr_id())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + datoExperienciaDto.getUsr_id()));
            datoExperiencia.setUsuario(usuario);
        } else {
            datoExperiencia.setUsuario(null);
        }

        return datoExperiencia;
    }

    @Override
    public DatoExperienciaDto consultDto(DatoExperiencia datoExperienciaDto) {
    return new DatoExperienciaDto(
            datoExperienciaDto.getExperiencia_id(),
            datoExperienciaDto.getCargo(),
            datoExperienciaDto.getEmpresa(),
            datoExperienciaDto.getFechaInicio(),
            datoExperienciaDto.getFechaFin(),
            datoExperienciaDto.getUbicacion(),
            datoExperienciaDto.getUsuario().getUsuario_id(),
            datoExperienciaDto.getUsuario().getNombre());
    }
}
