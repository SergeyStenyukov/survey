package com.fabrique.survey.repository;

import com.fabrique.survey.domain.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> getSurveyByFinishedDateAfter(LocalDate date);
}
