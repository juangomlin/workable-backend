package com.workable_sb.workable.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Beneficio {
  @Id
  private Short beneficioId;

  @Column(nullable = false, length = 255)
  private String nombre;
}
