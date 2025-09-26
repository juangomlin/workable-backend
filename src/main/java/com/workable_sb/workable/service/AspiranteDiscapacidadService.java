package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.RespAsignacionMasivaDTO;
import com.workable_sb.workable.dto.ResultadoAsignacionDTO;

public interface AspiranteDiscapacidadService {
    AspiranteDiscapacidadDto asignar(AspiranteDiscapacidadDto dto);

    List<AspiranteDiscapacidadDto> listarPorAspirante(Integer aspiranteId);

    List<AspiranteDiscapacidadDto> listarPorDiscapacidad(Short discapacidadId);

    void eliminarAsignacion(Integer aspiranteId, Short discapacidadId);

    RespAsignacionMasivaDTO asignarVarios(List<AspiranteDiscapacidadDto> asignaciones);

    List<ResultadoAsignacionDTO> asignarVariosNormal(List<AspiranteDiscapacidadDto> asignaciones);
}
