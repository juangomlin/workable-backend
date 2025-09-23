package com.workable_sb.workable.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.Feedback;

public interface FeedbackRepository extends JpaRepository <Feedback, Short>{

}
