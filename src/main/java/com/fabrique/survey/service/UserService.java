package com.fabrique.survey.service;

import com.fabrique.survey.domain.model.Survey;

import java.util.Set;

public interface UserService {

    void saveCompletedSurvey(long userId, Survey survey);

    Set<Survey> getCompletedSurveys(long userId);
}
