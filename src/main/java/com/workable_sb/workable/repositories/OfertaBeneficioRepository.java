package com.workable_sb.workable.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.OfertaBeneficio;
import com.workable_sb.workable.models.OfertaBeneficioId;

public interface OfertaBeneficioRepository extends JpaRepository<OfertaBeneficio, OfertaBeneficioId>{
  List<OfertaBeneficio> findById_ofertaId(Integer id);
  List<OfertaBeneficio> findById_beneficioId(Short id);
}
