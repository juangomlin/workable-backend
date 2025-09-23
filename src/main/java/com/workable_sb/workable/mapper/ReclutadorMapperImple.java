package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;
import com.workable_sb.workable.dto.ReclutadorDto;
import com.workable_sb.workable.models.Empresa;
import com.workable_sb.workable.models.Reclutador;
import com.workable_sb.workable.repositories.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ReclutadorMapperImple implements ReclutadorMapper {

    private final EmpresaRepository empresaRepository;

    public ReclutadorMapperImple(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Reclutador consult(ReclutadorDto reclutadorDto){
        
        Reclutador reclutador = new Reclutador();
        reclutador.setReclutador_id(reclutadorDto.getReclutador_id());
        reclutador.setNombre(reclutadorDto.getNom());
        reclutador.setClave(reclutadorDto.getClave());
        reclutador.setCorreo(reclutadorDto.getCorreo());
        reclutador.setFecharegistro(reclutadorDto.getFecharegistro());
        
        Empresa empresa = empresaRepository.findById(reclutadorDto.getEmpresa_id()).orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
        reclutador.setEmpresa(empresa);

        return reclutador;
    }

    @Override
    public ReclutadorDto consultDto(Reclutador reclutador){
        return new ReclutadorDto(
            reclutador.getReclutador_id(),
            reclutador.getNombre(),
            reclutador.getClave(),
            reclutador.getCorreo(),
            reclutador.getFecharegistro(),
            reclutador.getEmpresa().getEmpresa_id(),
            reclutador.getEmpresa().getNombre()
        );
    }
}