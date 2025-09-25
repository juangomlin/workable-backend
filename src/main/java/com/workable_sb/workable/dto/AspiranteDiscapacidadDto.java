package com.workable_sb.workable.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AspiranteDiscapacidadDto {

  @NotNull(message = "El id es obligatorio")
  private Integer aspi_id;
  private String nom_aspi;

  @NotNull(message = "El id es obligatorio")
  private Short disc_id;
  private String nom_dis;

}
