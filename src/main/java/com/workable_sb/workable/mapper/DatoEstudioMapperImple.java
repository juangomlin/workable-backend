package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.DatoEstudioDto;
import com.workable_sb.workable.models.DatoEstudio;
import com.workable_sb.workable.models.NivelEducativo;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.NivelEducativoRepository;
import com.workable_sb.workable.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class DatoEstudioMapperImple implements DatoEstudioMapper {

    private NivelEducativoRepository nivelEducativoRepository;
    private UsuarioRepository usuarioRepository;

    public DatoEstudioMapperImple(NivelEducativoRepository nivelEducativoRepository, UsuarioRepository usuarioRepository) {
        this.nivelEducativoRepository = nivelEducativoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public DatoEstudio consult(DatoEstudioDto datoEstudioDto) {
        DatoEstudio datoEstudio = new DatoEstudio();
        datoEstudio.setEstudio_id(datoEstudioDto.getEst_id());
        datoEstudio.setNombre(datoEstudioDto.getNom());
        datoEstudio.setFechaInicio(datoEstudioDto.getFechaIn());
        datoEstudio.setFechaFin(datoEstudioDto.getFechaFi());
        datoEstudio.setCertificado(datoEstudioDto.getCert());
        datoEstudio.setInstitucion(datoEstudioDto.getInst());

        NivelEducativo nivelEducativo = nivelEducativoRepository.findById(datoEstudioDto.getNivEdu_id()).orElseThrow(() -> new EntityNotFoundException("Nivel educativo no encontrado"));
        datoEstudio.setNivelEducativo(nivelEducativo);

        Usuario usuario = usuarioRepository.findById(datoEstudioDto.getUsr_id()).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        datoEstudio.setUsuario(usuario);

        return datoEstudio;
    }

    @Override
    public DatoEstudioDto consultDto(DatoEstudio entity) {
        return new DatoEstudioDto(
            entity.getEstudio_id(),
            entity.getNombre(),
            entity.getFechaInicio(),
            entity.getFechaFin(),
            entity.getCertificado(),
            entity.getInstitucion(),
            entity.getNivelEducativo().getNivelEducativo_id(),
            entity.getNivelEducativo().getNombre(),
            entity.getUsuario().getUsuario_id()
        );
    }
}
