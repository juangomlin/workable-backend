package com.workable_sb.workable.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedBack {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer feedBack_id;

  @Column (nullable = false)
  private String descripcion;

  @Column (nullable = false)
  private Date fechaCreacion;
}
