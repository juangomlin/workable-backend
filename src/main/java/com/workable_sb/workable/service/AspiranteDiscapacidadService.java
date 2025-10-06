package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.AspiranteAsignadoDto;
import com.workable_sb.workable.dto.AspiranteDiscapacidadDto;
import com.workable_sb.workable.dto.DiscapacidadAsignadaDto;
import com.workable_sb.workable.dto.RespAsignacionMasivaDTO;
import com.workable_sb.workable.dto.ResultadoAsignacionDTO;

public interface AspiranteDiscapacidadService {
    AspiranteDiscapacidadDto asignar(AspiranteDiscapacidadDto aspiranteDiscapacidadDto);

    List<AspiranteDiscapacidadDto> listarPorAspirante(Integer aspiranteId);

    List<AspiranteAsignadoDto> listarPorAspirante2(Integer empleadoId);

    List<AspiranteDiscapacidadDto> listarPorDiscapacidad(Short discapacidadId);

    List<DiscapacidadAsignadaDto> listarPorDiscapacidad2(Short empleadoId);

    void eliminarAsignacion(Integer aspiranteId, Short discapacidadId);

    RespAsignacionMasivaDTO asignarVarios(List<AspiranteDiscapacidadDto> asignaciones);

    List<ResultadoAsignacionDTO> asignarVariosNormal(List<AspiranteDiscapacidadDto> asignaciones);
}
