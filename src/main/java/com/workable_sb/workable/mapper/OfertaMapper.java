package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.OfertaDto;
import com.workable_sb.workable.models.Oferta;

public interface OfertaMapper {
    Oferta consult(OfertaDto ofertaDto);
    OfertaDto consulDto(Oferta entity);
}
