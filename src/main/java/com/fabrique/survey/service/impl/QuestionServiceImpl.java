package com.fabrique.survey.service.impl;

import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.repository.QuestionRepository;
import com.fabrique.survey.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Question question) {
        repository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
