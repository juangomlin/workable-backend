package com.workable_sb.workable.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"oferta_id", "beneficio_id"})
public class OfertaBeneficioId implements Serializable{
  public OfertaBeneficioId(Integer id, Integer id2){} 
    private Integer oferta_id;
    private Short beneficio_id;

}
