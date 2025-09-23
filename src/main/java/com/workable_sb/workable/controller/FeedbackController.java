package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;
import com.workable_sb.workable.service.FeedbackService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
  private final FeedbackService feedbackService;

  public FeedbackController(FeedbackService feedbackService) {
    this.feedbackService = feedbackService;
  }

  @PostMapping
  public ResponseEntity<FeedbackReadDto> guardar(@Valid @RequestBody FeedbackDto feedbackDto) {
    FeedbackReadDto entity = feedbackService.guardar(feedbackDto);
    return ResponseEntity.ok(entity);
  }
  

  @GetMapping("/{id}")
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
}
