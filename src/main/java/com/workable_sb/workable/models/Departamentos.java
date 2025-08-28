package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "departamentos")
public class Departamentos {
    @Id
    @Column(name = "departamento_id")
    private Integer departamento_id;

    @Column(nullable = false, length = 50)
    private String nomb_departamento;
}
