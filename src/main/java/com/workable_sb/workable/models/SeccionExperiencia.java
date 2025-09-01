package com.workable_sb.workable.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "seccion_experiencia")
public class SeccionExperiencia {
    @Id
    @Column(name = "experiencia_id")
    private Integer experiencia_id;

    @Column(nullable = false, length = 255)
    private String cargo;

    @Column(nullable = false, length = 255)
    private String emprnomb;

    @Column(nullable = false)
    private Date fechainicio;

    @Column(nullable = false)
    private Date fechasalida;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String ciudadempresa;

    @Column(nullable = false, length = 255)
    private String paisempresa;

    @OneToOne(optional = false)
    @JoinColumn(name = "expe_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_expe_id"))
    private Usuario usuario;
}
