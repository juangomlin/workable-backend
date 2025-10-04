package com.workable_sb.workable.models;

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
@NoArgsConstructor
@AllArgsConstructor
public class Favorito {
  private FavoritoId id = new FavoritoId();

  @ManyToOne
  @MapsId("aspiranteId")
  @JoinColumn(name = "aspirante_id", nullable = false, foreignKey = @ForeignKey(name = "FK_favorito_aspirante"))
  private Aspirante aspirante;

  @ManyToOne
  @MapsId("ofertaId")
  @JoinColumn(name = "oferta_id", nullable = false, foreignKey = @ForeignKey(name = "FK_favorito_oferta"))
  private Oferta oferta;
}
