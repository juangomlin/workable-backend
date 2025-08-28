package com.workable_sb.workable.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Table(name = "Oferta")

public class Oferta {
  @Id
  @Column(name = "Oferta_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false, length = 255)
  private String nomOfert;

  @Column(nullable = false, length = 255)
  private String descrip;

  @Column(nullable = false, length = 100)
  private String ubicTrab;

  private Date fechPu;
  private Date fechLimApli;

}
