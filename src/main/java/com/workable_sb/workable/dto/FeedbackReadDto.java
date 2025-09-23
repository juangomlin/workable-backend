package com.workable_sb.workable.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackReadDto {
  private Integer id;
  private String desc;
  private LocalDate fechaCre;
  
  private Short tipUsr_id;
  private String nom;
}
