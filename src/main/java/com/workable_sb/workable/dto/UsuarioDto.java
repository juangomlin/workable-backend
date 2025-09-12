package com.workable_sb.workable.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
  private Integer id;

  @NotNull
  private String nom;

  @NotNull
  private String ape;

  @NotNull
  private String cla;

  @NotNull
  private String corr;

  @NotNull(message = "El id de municipio es obligatorio")
  private Integer munici_id;

  private String nombreMunicipio;

  @NotNull(message = "El id de empresa es obligatorio")
  private Integer empre_id;

  private String nombreEmpresa;

  @NotNull(message = "El id de tipo de documento es obligatorio")
  private Integer tipDoc_id;

  private String nombreTipDoc;

  @NotNull(message = "El id de rol es obligatorio")
  private Integer rol;

  private String nombreRol;
}
