package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;
import com.workable_sb.workable.models.Feedback;
import com.workable_sb.workable.models.TipoUsuario;
import com.workable_sb.workable.repositories.TipoUsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class FeedbackMapperImple implements FeedbackMapper{

  private final TipoUsuarioRepository tipoUsuarioRepository;

  public FeedbackMapperImple(TipoUsuarioRepository tipoUsuarioRepository) {
    this.tipoUsuarioRepository = tipoUsuarioRepository;
  }

  @Override
  public Feedback consultEntity(FeedbackDto feedbackDto) {
    Feedback feedback = new Feedback();

    if(feedbackDto == null)
    return null;

    feedback.setDescripcion(feedbackDto.getDesc());
    feedback.setFechaCreacion(feedbackDto.getFechaCre());
    
    TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(feedbackDto.getTipUsr_id()).orElseThrow(() -> new EntityNotFoundException("tipo de usuario no encontrado"));
    feedback.setTipoUsuario(tipoUsuario);
    
    return feedback;
  }

  @Override
  public FeedbackReadDto consultReadDto(Feedback feedback) {
    if(feedback == null)
    return null;

    return new FeedbackReadDto(
      feedback.getFeedBack_id(),
      feedback.getDescripcion(),
      feedback.getFechaCreacion(),
      feedback.getTipoUsuario().getTipoUsuario_id(),
      feedback.getTipoUsuario().getNombre());
  }
}
