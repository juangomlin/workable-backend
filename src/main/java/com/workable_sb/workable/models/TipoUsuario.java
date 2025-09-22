package com.workable_sb.workable.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class TipoUsuario {
  @Id
  private Integer tipoUsuario_id;

  private String nombre;
}
