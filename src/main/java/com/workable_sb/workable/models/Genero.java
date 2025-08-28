package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "genero")
public class Genero {
    @Id
    @Column(name = "genero_id")
    private Byte genr_id;

    @Column(nullable = false)
    private String TipGenero;

}
