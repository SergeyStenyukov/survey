package com.fabrique.survey.repository;

import com.fabrique.survey.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
