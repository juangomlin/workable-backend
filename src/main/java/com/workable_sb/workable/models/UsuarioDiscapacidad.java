package com.workable_sb.workable.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDiscapacidad {

  @Embeddable
  public class UsuarioDiscapacidadId implements Serializable {
    private Integer usuario_id;
    private Short discapacidad_id;
  }

  @EmbeddedId
  private UsuarioDiscapacidadId id= new UsuarioDiscapacidadId();

  @ManyToOne
  @MapsId("usuario_id")
  @JoinColumn(name = "usuarioid", nullable = false, foreignKey = @ForeignKey(name = "FK_usuarioDiscapacidad_usuario"))
  private Usuario usuario;

  @ManyToOne
  @MapsId("discapacidad_id")
  @JoinColumn(name = "discapacidad_id", nullable = false, foreignKey = @ForeignKey(name = "FK_usuarioDiscapacidad_discapacidad"))
  private Discapacidad discapacidad;
}
