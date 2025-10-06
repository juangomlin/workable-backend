package com.workable_sb.workable.dto.oferta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfertaReadDto {
  private Integer id;
  private String titu;
  private String desc;
  private String ubi;
  private LocalDate fechaPu;
  private LocalDate fechLi;

  private Integer modalidad_id;
  private String modalNomb;

  private Integer tipoContrato_id;
  private String tipoConNomb;

  private Long empresa_id;
  private String empNomb;
}
