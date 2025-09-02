package com.workable_sb.workable.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"usuario_id", "discapacidad_id"})
public class UsuarioDiscapacidadId {

}
