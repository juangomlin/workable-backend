package com.workable_sb.workable.mapper;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;
import com.workable_sb.workable.models.Feedback;

public interface FeedbackMapper {
  Feedback consultEntity(FeedbackDto feedbackDto);
  FeedbackReadDto consultReadDto(Feedback feedback);
  
}
