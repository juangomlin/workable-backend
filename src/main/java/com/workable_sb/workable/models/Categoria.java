package com.workable_sb.workable.models;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "categoria_emprr")
public class Categoria {
    @Id
    @Column(name = "categ_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categ_id;

    @Column(nullable = false, length = 255)
    private String nombcatg;

    @Column(nullable = false)
    private Blob iconImg;

    @Column(nullable = false, length = 255)
    private String descrip;
}
