package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Municipio")

public class Municipio {
  @Id
  @Column(name = "munici_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 50)
  private String NombreMuni;

  @ManyToOne(optional = false)
  @JoinColumn(name = "departamento_municipio", nullable = false,
  foreignKey = @jakarta.persistence.ForeignKey(name = "FK_municipio_departamento"))
  private Departamento departamento;

}