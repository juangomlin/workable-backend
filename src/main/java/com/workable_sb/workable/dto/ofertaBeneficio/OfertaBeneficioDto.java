package com.workable_sb.workable.dto.ofertaBeneficio;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfertaBeneficioDto {
  @NotNull(message = "campo ofertaId es obligatrio")
  private Integer ofeId;
  private String titul;
  @NotNull(message = "campo beneficioId es obligatrio")
  private Short beneId;
  private String nomb;
}
