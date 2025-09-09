package com.workable_sb.workable.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OfertaDto {

    private Integer id;

    @NotNull
    private String tit;

    @NotNull
    private String des;

    @NotNull
    private String ubi;

    @NotNull
    private Date fePu;

    @NotNull
    private Date feLi;

    @NotNull(message = "La modalidad debe ser obligatoria")
    private Integer modalidad_id;

    private String nombreModalidad;

    @NotNull(message = "El tipo de contrato debe ser obligatorio")
    private Integer tipoContrato_id;

    private String nombreTipoContrato;

    @NotNull(message = "La empresa debe ser obligatoria")
    private Integer empresa_id;
    
    private String nombreEmpresa;

}
