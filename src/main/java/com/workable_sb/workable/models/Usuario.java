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
@Entity
@Data
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer usuario_id;

  @Column(nullable = false, length = 255)
  private String nombre;

  @Column(nullable = false, length = 255)
  private String apellido;

  @Column(nullable = false, length = 500)
  private String clave;

  @Column(nullable = false, length = 255 , unique = true)
  private String correo;

  @ManyToOne(optional = false)
  @JoinColumn(name = "municipio_usuario", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_municipio_usuario"))
  private Municipio municipio;

  @ManyToOne(optional = false)
  @JoinColumn(name = "empresa_usuario", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_empresa_usuario"))
  private Empresa empresa;

  @ManyToOne(optional = false)
  @JoinColumn(name = "tipo_documento_usuario", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_tipo_documento_usuario"))
  private TipDocumento tipDocumento;

  @ManyToOne(optional = false)
  @JoinColumn(name = "rol_usuario", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_rol_usuario"))
  private Rol rol;
}
