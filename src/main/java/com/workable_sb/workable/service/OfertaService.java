package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.oferta.OfertaDto;
import com.workable_sb.workable.dto.oferta.OfertaReadDto;

public interface OfertaService {
    OfertaReadDto guardar(OfertaDto ofertaDto);
    OfertaReadDto ListId(Integer id);
    List<OfertaReadDto> listarAll();
    void eliminar(Integer id);
}
