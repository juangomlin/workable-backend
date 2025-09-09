package com.workable_sb.workable.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartamentoDto {
  private Integer dep_id;

  @NotNull
  private String nom;
}
