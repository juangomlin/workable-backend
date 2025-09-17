package com.workable_sb.workable.service;

import com.workable_sb.workable.dto.ReclutadorDto;

public interface ReclutadorService {
    ReclutadorDto crear(ReclutadorDto reclutadorDto);
    ReclutadorDto listarTodos();
    ReclutadorDto buscarPorId(Integer reclutador_id);
    void eliminar(Integer reclutador_id);
}
