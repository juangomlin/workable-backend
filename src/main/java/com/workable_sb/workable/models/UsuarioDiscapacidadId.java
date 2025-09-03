package com.workable_sb.workable.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"usuario_id", "discapacidad_id"})
public class UsuarioDiscapacidadId implements Serializable{
  public UsuarioDiscapacidadId(Integer id, Integer id2) {}

  private Integer usuario_id;
  private Short discapacidad_id;
}
