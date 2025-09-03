package com.workable_sb.workable.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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

public class OfertaBeneficio {

  @Embeddable
  public class OfertaBeneficioId implements Serializable{
    private Integer oferta_id;
    private Short beneficio_id;
  }

  @EmbeddedId
  private OfertaBeneficioId id = new OfertaBeneficioId();

  @ManyToOne
  @MapsId("oferta_id")
  @JoinColumn(name = "oferta_id", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_ofertaBeneficio_oferta"))
  private Oferta oferta;

  @ManyToOne
  @MapsId("beneficio_id")
  @JoinColumn(name = "beneficio_id", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_ofertaBeneficio_beneficio"))
  private Beneficio beneficio;

}
