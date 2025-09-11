package com.workable_sb.workable.mapper;

import com.workable_sb.workable.models.DatoExperiencia;

public interface DatoExperienciaMapper {
    DatoExperiencia consult(DatoExperiencia datoExperiencia);
    DatoExperiencia consultDto(DatoExperiencia entity);
}
