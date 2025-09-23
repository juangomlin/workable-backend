package com.workable_sb.workable.service;

import java.util.List;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;

public interface FeedbackService {
  FeedbackReadDto guardar(FeedbackDto feedbackDto);
  FeedbackReadDto listId(Integer id);
  List<FeedbackReadDto> listAll();
  void eliminar(Integer Id);
}
