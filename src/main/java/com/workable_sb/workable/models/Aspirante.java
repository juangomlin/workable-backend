package com.workable_sb.workable.models;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "aspirante")
public class Aspirante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer usuario_id;

  @Column(nullable = false, length = 255)
  private String nombre;

  @Column(nullable = false, length = 255)
  private String apellido;

  @Column(nullable = false, length = 255 , unique = true)
  private String correo;

  @Column(nullable = false , length = 255)
  private String ubicacion;
  
  @Column(nullable = false)
  private Integer telefono;

  private Date fecha_Nacimiento;

 @Lob
private byte[] foto;

  @Column(nullable = false, length = 500)
  private String clave;

  @ManyToOne(optional = false)
  @JoinColumn(name = "tipoDocumento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_tipo_documento_aspirante"))
  private TipDocumento tipDocumento;

  
  @ManyToOne(optional = false)
  @JoinColumn(name = "municipio_id", nullable = false, foreignKey = @ForeignKey(name = "FK_municipio_aspirante"))
  private Municipio municipio;
  

  @ManyToOne(optional = false)
  @JoinColumn(name = "genero_id", nullable = false, foreignKey = @ForeignKey(name = "FK_genero_aspirante"))
  private Genero genero;
}
