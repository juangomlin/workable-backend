package com.workable_sb.workable.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {
  @NotNull
  private Long nit_id;
  @NotBlank
  private String nom;
  @NotBlank
  private String ubi;
  @NotBlank
  private String desc;
  @NotNull
  private Integer numTrab;
  @NotBlank
  private String correoCorp;
  private float punt;
  private LocalDate fechaCrea;

  @NotNull
  private Integer cat_id;
  private String nomCat;
  @NotNull
  private Integer munici_id;
  private String nomMunici;
}
