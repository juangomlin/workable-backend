package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "niveleducativo")
public class NivelEducativo {
    @Id
    @Column(name = "niveleducativo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer n_edu_id;

    @Column(nullable = false, length = 255)
    private String nvedunom;
}
