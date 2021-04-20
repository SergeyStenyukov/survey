package com.fabrique.survey.service;

import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.domain.model.Survey;

import java.util.List;

public interface SurveyService {

    void saveOrUpdate(Survey survey);

    List<Survey> getAll();

    List<Survey> getUnfinishedSurveys();

    void deleteById(long id);

    void addQuestion(long id, Question question);

    void removeQuestion(long id, Question question);
}
