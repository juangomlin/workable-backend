package com.workable_sb.workable.models;

import java.sql.Date;

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
@Table(name = "reclutador")
public class Reclutador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reclutador_id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String clave;

    @Column(nullable = false, length = 255)
    private String correo;

    @Column(nullable = false)
    private Date fecharegistro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_reclutador_empresa"))
    private Empresa empresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_reclutador_rol"))
    private Rol rol;
}
