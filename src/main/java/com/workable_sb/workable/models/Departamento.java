package com.workable_sb.workable.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Departamento {
  @Id
  @Column(name = "depart_id")
  @Generated(strategy = GenerationType.IDENTITY)
  private Integer id;

}
