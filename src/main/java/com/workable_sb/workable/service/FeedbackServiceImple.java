package com.workable_sb.workable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;
import com.workable_sb.workable.mapper.FeedbackMapper;
import com.workable_sb.workable.models.Feedback;
import com.workable_sb.workable.repositories.FeedbackRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FeedbackServiceImple implements FeedbackService{
  private final FeedbackRepository feedbackRepository;
  private final FeedbackMapper feedbackMapper;

  public FeedbackServiceImple(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper) {
    this.feedbackRepository = feedbackRepository;
    this.feedbackMapper = feedbackMapper;
  }

  @Override
  public FeedbackReadDto guardar(FeedbackDto feedbackDto) {
    Feedback entity = feedbackMapper.consultEntity(feedbackDto);
    Feedback guardado = feedbackRepository.save(entity);
    return feedbackMapper.consultReadDto(guardado);
  }

  @Override
  public FeedbackReadDto listId(Integer id) {
    return feedbackRepository.findById(id)
    .map(feedbackMapper::consultReadDto)
    .orElseThrow(() -> new EntityNotFoundException("feedback no encontrado"));
  }

  @Override
  public List<FeedbackReadDto> listAll() {
    return feedbackRepository.findAll().stream().map(feedbackMapper::consultReadDto).collect(Collectors.toList());
  }

  @Override
  public void eliminar(Integer id) {
    Feedback feedback = feedbackRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("feedback no encontrado"));
    feedbackRepository.delete(feedback);
  }
}
