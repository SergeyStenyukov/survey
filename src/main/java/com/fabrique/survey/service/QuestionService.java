package com.fabrique.survey.service;

import com.fabrique.survey.domain.model.Question;

import java.util.List;

public interface QuestionService {

    void save(Question question);

    List<Question> getAll();

    void deleteById(long id);
}
