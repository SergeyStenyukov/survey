package com.fabrique.survey.service.impl;

import com.fabrique.survey.domain.model.Survey;
import com.fabrique.survey.domain.model.User;
import com.fabrique.survey.repository.UserRepository;
import com.fabrique.survey.service.UserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveCompletedSurvey(long userId, Survey survey) {
        User user = findByIdOrThrowNotFound(userId);
        user.addSurvey(survey);
        userRepository.save(user);
    }

    @Override
    public Set<Survey> getCompletedSurveys(long userId) {
        return findByIdOrThrowNotFound(userId).getSurveys();
    }

    private User findByIdOrThrowNotFound(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find by id=" + id));
    }
}
