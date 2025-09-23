package com.workable_sb.workable.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
  @NotBlank
  private String desc;

  @NotNull
  private LocalDate fechaCre;

  @NotNull
  private Short tipUsr_id;
}
