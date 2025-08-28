package com.workable_sb.workable.models;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter                                                                                                                                 
@Table (name = "categoria_emprr")
public class CategoriaEmpresa {
    @Id
    @Column(name = "categ_id")
    private Integer categ_id;

    @Column(nullable = false, length = 255)
    private String nombcatg;

    @Column(nullable = false)
    private Blob iconImg;

    @Column(nullable = false, length = 255)
    private String descrip;
}
