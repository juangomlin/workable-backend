package com.workable_sb.workable.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {
  private Integer empr_id;

  @NotNull
  private String nom;

  @NotNull
  private String ubi;

  @NotNull
  private String desc;

  @NotNull(message = "la categoria es obligatoria")
  private Integer cate_id;
  private String nom_cat;

  @NotNull(message = "el municipio es obligatorio")
  private Integer munici_id;

  private String nom_munici;
}
