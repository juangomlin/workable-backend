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

  @NotNull(message = "el ID de categoria es obligatorio")
  private Integer cate_id;
  private String nom_cat;
}
