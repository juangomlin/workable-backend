package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.ReclutadorDto;
import com.workable_sb.workable.mapper.ReclutadorMapper;
import com.workable_sb.workable.models.Reclutador;
import com.workable_sb.workable.repositories.AspiranteRepository;
import com.workable_sb.workable.repositories.EmpresaRepository;
import com.workable_sb.workable.repositories.ReclutadorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReclutadorServiceImple implements ReclutadorService {

    private final AspiranteRepository aspiranteRepository;
    private final ReclutadorRepository reclutadorRepository;
    private final ReclutadorMapper reclutadorMapper;
    private final EmpresaRepository empresaRepository;

    public ReclutadorServiceImple(ReclutadorRepository reclutadorRepository,ReclutadorMapper reclutadorMapper, EmpresaRepository empresaRepository, AspiranteRepository aspiranteRepository, AspiranteRepository aspiranteRepository2) {
        this.reclutadorRepository = reclutadorRepository;
        this.reclutadorMapper = reclutadorMapper;
        this.empresaRepository = empresaRepository;
        this.aspiranteRepository = aspiranteRepository;
    }

    @Override
    public ReclutadorDto crearyupdate(ReclutadorDto reclutadorDto) {
        Reclutador reclutador = reclutadorMapper.consult(reclutadorDto);
        Reclutador guardado = reclutadorRepository.save(reclutador);
        return reclutadorMapper.consultDto(guardado);
    }

    @Override
    public ReclutadorDto buscarPorId(Integer reclutador_id) {
        return reclutadorRepository.findById(reclutador_id)
            .map(reclutadorMapper::consultDto)
            .orElseThrow(() -> new EntityNotFoundException("Reclutador no encontrado"));
    }

    @Override
    public List<ReclutadorDto> listarTodos() {
        return reclutadorRepository.findAll()
            .stream()
            .map(reclutadorMapper::consultDto)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer reclutador_id) {
        reclutadorRepository.deleteById(reclutador_id);
    }
}
