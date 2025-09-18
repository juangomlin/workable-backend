package com.workable_sb.workable.models;

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
public class AspiranteDiscapacidad {

  @EmbeddedId
  private AspiranteDiscapacidadId id = new AspiranteDiscapacidadId();

  @ManyToOne
  @MapsId("aspirante_id")
  @JoinColumn(name = "aspiranteid", nullable = false, foreignKey = @ForeignKey(name = "FK_aspiranteDiscapacidad_aspirante"))
  private Aspirante aspirante;

  @ManyToOne
  @MapsId("discapacidad_id")
  @JoinColumn(name = "discapacidad_id", nullable = false, foreignKey = @ForeignKey(name = "FK_aspiranteDiscapacidad_discapacidad"))
  private Discapacidad discapacidad;
}
