package com.workable_sb.workable.service;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.mapper.OfertaBeneficioMapper;
import com.workable_sb.workable.repositories.OfertaBeneficioRepository;

@Service
public class OfertaBeficioServiceImpl implements OfertaBeneficioService{
  private final OfertaBeneficioMapper mapper;
  private final OfertaBeneficioRepository repository;

  public OfertaBeneficioServiceImpl (OfertaBeneficioMapper mapper, OfertaBeneficioRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }
}
