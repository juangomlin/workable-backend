package com.workable_sb.workable.models;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "dato_experiencia")
public class DatoExperiencia {
  @Id
  private Integer experiencia_id;

  @Column(nullable = false, length = 255)
  private String cargo;

  @Column(nullable = false, length = 255)
  private String nombreEmpresa;

  @Column(nullable = false)
  private Date fechaInicio;

  @Column(nullable = false)
  private Date fechaFin;

  @Column(nullable = false, length = 255)
  private String descripcion;

  @Column(nullable = false, length = 255)
  private String ciudad;

  @Column(nullable = false, length = 255)
  private String pais;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", foreignKey = @ForeignKey(name = "FK_datoExpreiencia_Usuario"))
  private Usuario usuario;
}
