package com.workable_sb.workable.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.AspiranteDiscapacidad;
import com.workable_sb.workable.models.AspiranteDiscapacidadId;

public interface AspiranteDiscapacidadRepository extends JpaRepository<AspiranteDiscapacidad, AspiranteDiscapacidadId> {
    List<AspiranteDiscapacidad> findById_aspiranteId(Integer aspirante_id);
    List<AspiranteDiscapacidad> findById_discapacidadId(Short discapacidad_id);
}
