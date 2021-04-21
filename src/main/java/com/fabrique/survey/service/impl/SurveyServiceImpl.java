package com.fabrique.survey.service.impl;

import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.domain.model.Survey;
import com.fabrique.survey.repository.SurveyRepository;
import com.fabrique.survey.service.SurveyService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public void saveOrUpdate(Survey survey) {
        surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        surveyRepository.deleteById(id);
    }

    @Override
    public void addQuestion(long id, Question question) {
        Survey survey = findByIdOrThrowNotFound(id);
        List<Question> surveyQuestions = survey.getQuestions();
        surveyQuestions.add(question);
        survey.setQuestions(surveyQuestions);
        surveyRepository.save(survey);
    }

    @Override
    public void removeQuestion(long id, Question question) {
        Survey survey = findByIdOrThrowNotFound(id);
        List<Question> surveyQuestions = survey.getQuestions();
        surveyQuestions.remove(question);
        survey.setQuestions(surveyQuestions);
        surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getUnfinishedSurveys() {
        return surveyRepository.getSurveyByFinishedDateAfter(LocalDate.now());
    }

    @Override
    public Survey getById(long id) {
        return findByIdOrThrowNotFound(id);
    }

    private Survey findByIdOrThrowNotFound(long id) {
        return surveyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find by id=" + id));
    }
}
