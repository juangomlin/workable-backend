package com.workable_sb.workable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workable_sb.workable.dto.FeedbackDto;
import com.workable_sb.workable.dto.FeedbackReadDto;
import com.workable_sb.workable.service.FeedbackService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
  public ResponseEntity<FeedbackReadDto> listId(@PathVariable Integer id) {
    FeedbackReadDto entity = feedbackService.listId(id);
    return ResponseEntity.ok(entity);
  }
  
  @GetMapping
  public ResponseEntity<List<FeedbackReadDto>> listAll() {
    List<FeedbackReadDto> entitys = feedbackService.listAll();
    return ResponseEntity.ok(entitys);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    feedbackService.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
