package com.workable_sb.workable.models;

import java.util.Date;

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
@Table(name = "postulacion")
public class Postulacion {
  @Id
  @Column(name = "postulacion_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Date fechaPost;

  @ManyToOne(optional = false)
  @JoinColumn(name = "estado_postulacion", nullable = false,
  foreignKey = @jakarta.persistence.ForeignKey(name = "FK_estado_postulacion"))
  private Estado estado;

  @ManyToOne(optional = false)
  @JoinColumn(name = "oferta_postulacion", nullable = false,
  foreignKey = @jakarta.persistence.ForeignKey(name = "FK_oferta_postulacion"))
  private Oferta oferta;

  @ManyToOne(optional = false)
  @JoinColumn(name = "usuario_postulacion", nullable = false,
  foreignKey = @jakarta.persistence.ForeignKey(name = "FK_usuario_postulacion"))
  private Usuario usuario;
}
