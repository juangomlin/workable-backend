package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.ReclutadorDto;

public interface ReclutadorService {
    ReclutadorDto crearyupdate(ReclutadorDto reclutadorDto);
    List<ReclutadorDto> listarTodos();
    ReclutadorDto buscarPorId(Integer reclutador_id);
    void eliminar(Integer reclutador_id);
}
