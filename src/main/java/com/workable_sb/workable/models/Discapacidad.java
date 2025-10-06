package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Discapacidad {
    @Id
    private Short discapacidadId;

    @Column(nullable = false, unique = true)
    private String nombre;
}
