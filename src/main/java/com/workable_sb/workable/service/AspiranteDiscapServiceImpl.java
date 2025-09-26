package com.workable_sb.workable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.RespAsignacionMasivaDTO;
import com.workable_sb.workable.dto.ResultadoAsignacionDTO;
import com.workable_sb.workable.mapper.AspiranteDiscapMapper;
import com.workable_sb.workable.models.AspiranteDiscapacidad;
import com.workable_sb.workable.models.AspiranteDiscapacidadId;
import com.workable_sb.workable.repositories.AspiranteDiscapacidadRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AspiranteDiscapServiceImpl implements AspiranteDiscapacidadService {

    private final AspiranteDiscapacidadRepository repository;
    private final AspiranteDiscapMapper mapper;

    public AspiranteDiscapServiceImpl(AspiranteDiscapacidadRepository repository, AspiranteDiscapMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AspiranteDiscapacidadDto asignar(AspiranteDiscapacidadDto dto) {
        AspiranteDiscapacidad relacion = mapper.consult(dto);
        AspiranteDiscapacidadId id = new AspiranteDiscapacidadId(dto.getAspi_id(), dto.getDisc_id());
        if (repository.existsById(id)) {
            throw new IllegalStateException("Ya existe esta relación Aspirante–Discapacidad");
        }

        AspiranteDiscapacidad guardado = repository.save(relacion);
        return mapper.consultDto(guardado);
    }

    @Override
    public List<AspiranteDiscapacidadDto> listarPorAspirante(Integer aspiranteId) {
        return repository.findByAspirante_AspiranteId(aspiranteId)
                .stream()
                .map(mapper::consultDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AspiranteDiscapacidadDto> listarPorDiscapacidad(Short discapacidadId) {
        return repository.findByDiscapacidad_DiscapacidadId(discapacidadId)
                .stream()
                .map(mapper::consultDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAsignacion(Integer aspiranteId, Short discapacidadId) {
        AspiranteDiscapacidadId id = new AspiranteDiscapacidadId(aspiranteId, discapacidadId);
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Relación no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public RespAsignacionMasivaDTO asignarVarios(List<AspiranteDiscapacidadDto> asignaciones) {
        List<ResultadoAsignacionDTO> resultados = new ArrayList<>();
        int asignadas = 0, duplicadas = 0, errores = 0;

        for (AspiranteDiscapacidadDto dto : asignaciones) {
            ResultadoAsignacionDTO resultado = new ResultadoAsignacionDTO();
            resultado.setAspiranteId(dto.getAspi_id().longValue());
            resultado.setDiscapacidadId(dto.getDisc_id().longValue());

            try {
                AspiranteDiscapacidadId id = new AspiranteDiscapacidadId(dto.getAspi_id(), dto.getDisc_id());
                if (repository.existsById(id)) {
                    resultado.setEstado("DUPLICADO");
                    resultado.setMensaje("Ya existe esta relación");
                    duplicadas++;
                } else {
                    AspiranteDiscapacidad relacion = mapper.consult(dto);
                    repository.save(relacion);
                    resultado.setEstado("ASIGNADO");
                    resultado.setMensaje("Asignación exitosa");
                    asignadas++;
                }
            } catch (Exception e) {
                resultado.setEstado("ERROR");
                resultado.setMensaje(e.getMessage());
                errores++;
            }

            resultados.add(resultado);
        }

        RespAsignacionMasivaDTO response = new RespAsignacionMasivaDTO();
        response.setTotalSolicitudes(asignaciones.size());
        response.setTotalAsignadas(asignadas);
        response.setTotalDuplicadas(duplicadas);
        response.setTotalErrores(errores);
        response.setResultados(resultados);

        return response;
    }

    @Override
    public List<ResultadoAsignacionDTO> asignarVariosNormal(List<AspiranteDiscapacidadDto> asignaciones) {
        List<ResultadoAsignacionDTO> resultados = new ArrayList<>();

        for (AspiranteDiscapacidadDto dto : asignaciones) {
            ResultadoAsignacionDTO resultado = new ResultadoAsignacionDTO();
            resultado.setEmpleadoId(dto.getAspi_id().longValue());
            resultado.setProyectoId(dto.getDisc_id().longValue());

            try {
                AspiranteDiscapacidadId id = new AspiranteDiscapacidadId(dto.getAspi_id(), dto.getDisc_id());
                if (repository.existsById(id)) {
                    resultado.setEstado("DUPLICADO");
                    resultado.setMensaje("Ya existe esta relación");
                } else {
                    AspiranteDiscapacidad relacion = mapper.consult(dto);
                    repository.save(relacion);
                    resultado.setEstado("ASIGNADO");
                    resultado.setMensaje("Asignación exitosa");
                }
            } catch (Exception e) {
                resultado.setEstado("ERROR");
                resultado.setMensaje(e.getMessage());
            }

            resultados.add(resultado);
        }

        return resultados;
    }
}


