package com.workable_sb.workable.dto;

import java.util.Date;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AspiranteDto {

  private Integer id;

  @NotBlank
  private String nom;

  @NotBlank
  private String ape;

  @NotBlank
  private String corr;

  @NotBlank
  private String ubi;

  @NotNull
  private Integer tel;

  @NotNull
  private Date feNa;

  @Lob
  private byte[] foto;

  @NotNull
  private String cla;

  @NotNull(message = "El id de genero es obligatorio")
  private Short  genero_id;

  @NotNull(message = "El id de tipo de documento es obligatorio")
  private Integer tipDoc_id;

  @NotNull(message = "El id de municipio es obligatorio")
  private Integer munici_id;

}
