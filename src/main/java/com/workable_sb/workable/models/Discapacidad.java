package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discapacidad")
public class Discapacidad {
    @Id
    @Column(name = "discapa_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Short discapa_id;

    @Column(nullable = false, unique = true)
    private String NombDiscap;
}
