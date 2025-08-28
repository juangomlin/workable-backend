package com.workable_sb.workable.models;

import java.util.Date;

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
@Table(name = "Postulacion")
public class Postulacion {
  @Id
  @Column(name = "Postulacion_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Date fechaPost;
}
