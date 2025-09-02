package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Niveleducativo")
public class NivelEducativo {
    @Id
    @Column(name = "Nivel_edu_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer niv_edu_id;

    @Column(nullable = false, length = 255)
    private String niveledunom;
}
