package com.workable_sb.workable.service.ofertaBeneficio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.beneficio.BeneficioAssignDto;
import com.workable_sb.workable.dto.oferta.OfertaAssignDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenMassResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfeBenResultDto;
import com.workable_sb.workable.dto.ofertaBeneficio.OfertaBeneficioDto;
import com.workable_sb.workable.mapper.OfertaBeneficioMapper;
import com.workable_sb.workable.models.OfertaBeneficio;
import com.workable_sb.workable.models.OfertaBeneficioId;
import com.workable_sb.workable.repositories.OfertaBeneficioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OfertaBeneficioServiceImpl implements OfertaBeneficioService{
  private final OfertaBeneficioMapper mapper;
  private final OfertaBeneficioRepository repository;

  public OfertaBeneficioServiceImpl (OfertaBeneficioMapper mapper, OfertaBeneficioRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public OfertaBeneficioDto assign(OfertaBeneficioDto dto) {
    OfertaBeneficio entity = mapper.toEntity(dto);
    OfertaBeneficioId id = new OfertaBeneficioId(dto.getOfeId(), dto.getBeneId());

    if (repository.existsById(id)) {
      throw new IllegalStateException("Ya existe esta relaicon Oferta-Beneficio");
    }
    OfertaBeneficio guardado =repository.save(entity);
    return mapper.toDto(guardado);
  }

  @Override
  public List<OfertaBeneficioDto> listByOferta(Integer ofertaId) {
    return repository.findById_ofertaId(ofertaId)
    .stream()
    .map(mapper::toDto)
    .collect(Collectors.toList());
  }

  @Override 
  public List<OfertaAssignDto> listByOferta2(Integer ofertaId) {
    return repository.findById_ofertaId(ofertaId)
    .stream()
    .map(mapper::consultByOferta)
    .collect(Collectors.toList());
  }

  @Override
  public List<OfertaBeneficioDto> listByBeneficio(Short beneficioId) {
    return repository.findById_beneficioId(beneficioId)
    .stream()
    .map(mapper::toDto)
    .collect(Collectors.toList());
  }

  @Override
  public List<BeneficioAssignDto> listByBeneficio2(Short beneficioId) {
    return repository.findById_beneficioId(beneficioId)
    .stream()
    .map(mapper::consultByBeneficio)
    .collect(Collectors.toList());
  }

  @Override
  public void deleteAssign(Integer ofertaId, Short beneficioId) {
    OfertaBeneficioId id = new OfertaBeneficioId(ofertaId, beneficioId);
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Realcion no encontrada");
    }
    repository.deleteById(id);
  }

  @Override
  public OfeBenMassResultDto massAssign(List<OfertaBeneficioDto> asignaciones) {
    List<OfeBenResultDto> resultados = new ArrayList<>();
    int asignadas = 0, duplicadas = 0, errores = 0;

    for (OfertaBeneficioDto dto : asignaciones) {
      OfeBenResultDto resultado = new OfeBenResultDto();
      resultado.setOfeId(dto.getOfeId());
      resultado.setBeneId(dto.getBeneId());

      try {
        OfertaBeneficioId id = new OfertaBeneficioId(dto.getOfeId(), dto.getBeneId());
        if (repository.existsById(id)) {
          resultado.setEstado("DUPLICADO");
          resultado.setMensaje("Ya existe esta relacion");
          duplicadas++;
        } else {
          OfertaBeneficio relacion = mapper.toEntity(dto);
          repository.save(relacion);
          resultado.setEstado("ASIGNADO");
          resultado.setMensaje("Asignacion exitosa");
          asignadas++;
        }
      } catch (Exception e) {
        resultado.setEstado("ERROR");
        resultado.setMensaje(e.getMessage());
      }
      resultados.add(resultado);
    }

    OfeBenMassResultDto response = new OfeBenMassResultDto();
    response.setTotalSolicitudes(asignaciones.size());
    response.setTotalAsignadas(asignadas);
    response.setTotalDuplicadas(duplicadas);
    response.setTotalErrores(errores);
    response.setResultados(resultados);

    return response;
  }

  @Override
  public List<OfeBenResultDto> massAssign2(List<OfertaBeneficioDto> asignaciones) {
    List<OfeBenResultDto> resultados = new ArrayList<>();

    for (OfertaBeneficioDto dto : asignaciones) {
      OfeBenResultDto resultado = new OfeBenResultDto();
      resultado.setOfeId(dto.getOfeId());
      resultado.setBeneId(dto.getBeneId());

      try {
        OfertaBeneficioId id = new OfertaBeneficioId(dto.getOfeId(), dto.getBeneId());
        if (repository.existsById(id)) {
          resultado.setEstado("DUPLICADO");
          resultado.setMensaje("Esta relacion ya existe");
        } else {
          OfertaBeneficio relacion = mapper.toEntity(dto);
          repository.save(relacion);
          resultado.setEstado("ASIGNADO");
          resultado.setMensaje("Asignacion exitosa");
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
