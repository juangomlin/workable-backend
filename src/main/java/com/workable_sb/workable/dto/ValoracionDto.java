package com.workable_sb.workable.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ValoracionDto {

  private Integer id;

  @NotNull
  private String desc;

  @NotNull
  private Float punt;

  @NotNull
  private Date feVa;

  @NotNull(message = "El id de empresa debe ser obligatorio")
  private Integer empresa_id;
  private String nombreEmpresa;

  @NotNull(message = "El id de usuario debe ser obligatorio")
  private Integer usuario_id;
  private String nombreUsuario;

}
