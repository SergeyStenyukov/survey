package com.fabrique.survey.api;

import com.fabrique.survey.domain.model.Survey;
import com.fabrique.survey.service.SurveyService;
import com.fabrique.survey.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static com.fabrique.survey.api.UserResource.BASE_URL;


@RestController
@RequestMapping(BASE_URL)
@PreAuthorize("hasRole('USER')")
@Api(value = "User-surveys", tags = "User-surveys")
public class UserResource {

    public static final String BASE_URL = "api/user-surveys";

    private final UserService userService;

    private final SurveyService surveyService;

    public UserResource(UserService userService, SurveyService surveyService) {
        this.userService = userService;
        this.surveyService = surveyService;
    }

    @ApiOperation(value = "Get available surveys")
    @GetMapping
    public List<Survey> getAvailableSurveys() {
        return surveyService.getUnfinishedSurveys();
    }

    @ApiOperation(value = "Get survey")
    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable long id) {
        return surveyService.getById(id);
    }

    @ApiOperation(value = "Save user's completed survey")
    @PostMapping("user/{id}")
    public void saveCompletedSurvey(@PathVariable long id, @RequestBody Survey survey) {
        userService.saveCompletedSurvey(id, survey);
    }

    @ApiOperation(value = "Get user's completed surveys")
    @GetMapping("user/{id}")
    public Set<Survey> getCompletedSurveys(@PathVariable long id) {
        return userService.getCompletedSurveys(id);
    }
}
