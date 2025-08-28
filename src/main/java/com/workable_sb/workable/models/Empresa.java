package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "empresa")
public class Empresa {
    @Id
    @Column(name = "empresa_id")
    private Integer empresa_id;

    @Column(nullable = false, length = 255)
    private String nombempr;

    @Column(nullable = false, length = 255)
    private String ubicacionempr;

    @Column(nullable = false, length = 255)
    private String descripcionempr;
}
