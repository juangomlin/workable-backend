package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(optional  = false, fetch = FetchType.LAZY)
    @JoinColumn (name = "categ_id", nullable = false,
    foreignKey = @jakarta.persistence.ForeignKey(name = "FK_categ_id"))
    private CategoriaEmpresa categoriaEmpresa;
}
