package com.workable_sb.workable.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
