package com.workable_sb.workable.models;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "dato_estudio")
public class DatoEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estudio_id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @Column(nullable = false)
    private String institucion;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] certificado;

    @ManyToOne(optional = false)
    @JoinColumn (name = "nivelEducativo_id", nullable = false, foreignKey = @ForeignKey(name = "FK_datosEstudios_nivelEducativo"))
    private NivelEducativo nivelEducativo;

    @ManyToOne(optional = false)
    @JoinColumn (name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_datoEstudio_usuario"))
    private Usuario usuario;
}