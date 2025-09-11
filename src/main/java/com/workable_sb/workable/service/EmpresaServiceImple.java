package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.EmpresaDto;
import com.workable_sb.workable.mapper.EmpresaMapper;
import com.workable_sb.workable.models.Empresa;
import com.workable_sb.workable.repositories.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaServiceImple implements EmpresaService{

  private final EmpresaRepository empresaRepository;
  private final EmpresaMapper empresaMapper;

  public EmpresaServiceImple(EmpresaRepository empresaRepository, EmpresaMapper
  empresaMapper) {
    this.empresaMapper = empresaMapper;
    this.empresaRepository = empresaRepository;
  }

  @Override
  public EmpresaDto guardar(EmpresaDto dto) {
    Empresa empresa = empresaMapper.consultEntity(dto);
    Empresa guardado = empresaRepository.save(empresa);
    return empresaMapper.consultDto(guardado);
  }

  @Override
  public EmpresaDto listId(Integer id) {
    return empresaRepository.findById(id).map(empresaMapper::consultDto).orElseThrow(() -> new EntityNotFoundException("empresa no encontrada"));
  }

  @Override
  public List<EmpresaDto> listAll() {
    return empresaRepository.findAll().stream().map(empresaMapper::consultDto).collect(Collectors.toList());
  }

  @Override
  public void eliminar(Integer id) {
    empresaRepository.deleteById(id);
  }
}
