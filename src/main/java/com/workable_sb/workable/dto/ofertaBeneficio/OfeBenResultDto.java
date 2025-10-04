package com.workable_sb.workable.dto.ofertaBeneficio;

import lombok.Data;

@Data
public class OfeBenResultDto {
  private Integer ofeId;
  private Short beneId;
  private String estado; // asignado, duplicado, no encontrado
  private String mensaje; // detalle del resultado
}
