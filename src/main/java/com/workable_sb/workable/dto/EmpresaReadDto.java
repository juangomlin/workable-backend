package com.workable_sb.workable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaReadDto {
  private Integer empr_id;

  private String nom;

  private String ubi;

  private String desc;

  private Integer cate_id;
  private String nom_cat;

  private Integer munici_id;
  private String nom_munici;
}
