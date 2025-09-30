package com.workable_sb.workable.dto;

import lombok.Data;

@Data
public class BeneficioAsignacionDto {
  private Integer ofeId;
  private Short beneId;
  private Integer estado; // asignado, duplicado, no encontrado
  private String mensaje; // detalle del resultado
}
