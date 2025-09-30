package com.workable_sb.workable.dto;

import java.util.List;

import lombok.Data;

@Data
public class BeneficioAsignacionMasivaDto {
  private int totalSolicitudes;
  private int totalAsignadas;
  private int totalDuplicadas;
  private int totalErrores;
  private List<BeneficioAsignacionDto> resultados;
}
