package com.workable_sb.workable.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "rol")
@Getter
public class Rol {
  @Id
  private Short rol_id;
  
  @Column(nullable = false, length = 10)
  private String nombre;
}
