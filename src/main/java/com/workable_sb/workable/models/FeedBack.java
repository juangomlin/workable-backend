package com.workable_sb.workable.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer feedBack_id;

  @Column (nullable = false)
  private String descripcion;

  @Column (nullable = false)
  private LocalDate fechaCreacion;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tipoUsuario__id", nullable = false, foreignKey = @ForeignKey(name = "FK_feedBack_tipoUsuario"))
  private TipoUsuario tipoUsuario;
}
