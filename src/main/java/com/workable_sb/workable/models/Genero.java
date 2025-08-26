package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "genero")
public class Genero {
    @Id
    @Column(name = "genr_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Byte genr_id;

    @Column(nullable = false)
    private String TipGenero;

}
