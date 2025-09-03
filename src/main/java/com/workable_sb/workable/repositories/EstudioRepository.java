package com.workable_sb.workable.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workable_sb.workable.models.SeccionEstudios;

public interface EstudioRepository extends JpaRepository<SeccionEstudios, Integer> {

}
