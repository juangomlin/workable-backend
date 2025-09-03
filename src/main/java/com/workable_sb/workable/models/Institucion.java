package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Entity
@Getter
@Table (name = "institucion")

public class Institucion {
    @Id
    @Column(name = "institu_id")
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer institu_id;
    
    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String ciudad;
    
    @Column(nullable = false, length = 255)
    private String departam;

    @Column(nullable = false, length = 255)
    private String pais;
}
