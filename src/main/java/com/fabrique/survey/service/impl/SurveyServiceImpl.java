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

    private final SurveyRepository repository;

    public SurveyServiceImpl(SurveyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveOrUpdate(Survey survey) {
        repository.save(survey);
    }

    @Override
    public List<Survey> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void addQuestion(long id, Question question) {
        Survey survey = findByIdOrThrowNotFound(id);
        List<Question> surveyQuestions = survey.getQuestions();
        surveyQuestions.add(question);
        survey.setQuestions(surveyQuestions);
        repository.save(survey);
    }

    @Override
    public void removeQuestion(long id, Question question) {
        Survey survey = findByIdOrThrowNotFound(id);
        List<Question> surveyQuestions = survey.getQuestions();
        surveyQuestions.remove(question);
        survey.setQuestions(surveyQuestions);
        repository.save(survey);
    }

    @Override
    public List<Survey> getUnfinishedSurveys() {
        return repository.getSurveyByFinishedDateAfter(LocalDate.now());
    }

    private Survey findByIdOrThrowNotFound(long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find by id=" + id));
    }
}
