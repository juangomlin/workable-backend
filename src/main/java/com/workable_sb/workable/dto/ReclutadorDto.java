package com.workable_sb.workable.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReclutadorDto {
    private Integer reclutador_id;

    @NotNull
    private String nom;

    @NotNull
    private String clave;

    @NotNull
    private String correo;

    @NotNull
    private Date fecharegistro;
    // borrar

    @NotNull(message = "el id de empresa es obligatorio")
    private Integer empresa_id;
    private String empresa_nom;
}
