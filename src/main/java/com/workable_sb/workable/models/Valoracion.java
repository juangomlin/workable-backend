package com.workable_sb.workable.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "valoracion")
public class Valoracion {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer valoracion_id;

	@Column(nullable = false, length = 255)
	private String descripcion;

	@Column(nullable = false)
	private float puntuacion;

	@Column(nullable = false)
	private Date fecha_valoracion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "empresa_id", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_empresa_valoracion"))
	private Empresa empresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_usuario_valoracion"))
	private Usuario usuario;
}
