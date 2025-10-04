package com.workable_sb.workable.dto.favorito;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class favoritoDto {
  @NotNull(message = "id de aspirante obligatorio")
  private Integer aspId;

  @NotNull(message = "id de oferta obligatorio")
  private Integer ofeId;
  private Integer ofeTit;
  private String ofeEmpresa;
}
