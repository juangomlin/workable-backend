package com.workable_sb.workable.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeneroDto {
    private Long genero_id;

    @NotNull
    private String tipo;

}
