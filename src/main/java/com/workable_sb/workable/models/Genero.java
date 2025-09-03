package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table (name = "genero")
public class Genero {
    @Id
    private Boolean genero_id;

    @Column(nullable = false, length = 100)
    private String TipGenero;
}
