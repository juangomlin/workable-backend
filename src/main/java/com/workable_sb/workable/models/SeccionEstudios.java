package com.workable_sb.workable.models;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}