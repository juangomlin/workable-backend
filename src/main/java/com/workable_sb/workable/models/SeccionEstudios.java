package com.workable_sb.workable.models;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "seccion_estudios")
public class SeccionEstudios {
    @Id
    @Column(name = "estud_id")
    private Integer estud_id;

    @Column(nullable = false, length = 255)
    private String nombreprog;

    @Column(nullable = false)
    private Date fechaini;

    @Column(nullable = false)
    private Date fechafin;

    @Column(nullable = false)
    private Blob certificacion;

    @ManyToOne(optional = false)
    @JoinColumn (name = "n_edu_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_n_edu_id"))
    private NivelEducativo nivelEducativo;

    @ManyToOne(optional = false)
    @JoinColumn (name = "institu_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_institu_id"))
    private Institucion institucion;

    @OneToOne(optional = false)
    @JoinColumn (name = "usr_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_usr_id"))
    private Usuario usuario;
    

}