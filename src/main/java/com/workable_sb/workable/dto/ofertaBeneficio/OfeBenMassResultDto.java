package com.workable_sb.workable.dto.ofertaBeneficio;

import java.util.List;

import lombok.Data;

@Data
public class OfeBenMassResultDto {
  private int totalSolicitudes;
  private int totalAsignadas;
  private int totalDuplicadas;
  private int totalErrores;
  private List<OfeBenResultDto> resultados;
}
