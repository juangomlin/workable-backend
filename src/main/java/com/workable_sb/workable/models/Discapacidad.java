package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "discapacidad")
public class Discapacidad {
    @Id
    private Short discapacidad_id;

    @Column(nullable = false, unique = true)
    private String nombre;
}
