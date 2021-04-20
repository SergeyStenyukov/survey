package com.fabrique.survey.api;

import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.domain.model.Survey;
import com.fabrique.survey.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.fabrique.survey.api.SurveyResource.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
@Api(value = "Surveys", tags = "Surveys")
public class SurveyResource {

    public static final String BASE_URL = "api/surveys";

    private final SurveyService surveyService;

    public SurveyResource(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @ApiOperation(value = "Save survey")
    @PostMapping
    public ResponseEntity<Survey> save(@RequestBody Survey survey) {
        surveyService.saveOrUpdate(survey);
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all surveys")
    @GetMapping
    public List<Survey> getAll() {
        return surveyService.getAll();
    }

    @ApiOperation(value = "Delete survey")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        surveyService.deleteById(id);
    }

    @ApiOperation(value = "Add question to survey")
    @PostMapping("/{id}/add-question")
    public ResponseEntity<Question> addQuestionToSurvey(@PathVariable long id, @RequestBody Question question) {
        surveyService.addQuestion(id, question);
        return new ResponseEntity<>(question, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Remove question from survey")
    @DeleteMapping("/{id}/remove-question")
    public ResponseEntity<Question> removeQuestionFromSurvey(@PathVariable long id, @RequestBody Question question) {
        surveyService.removeQuestion(id, question);
        return new ResponseEntity<>(question, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Get unfinished surveys")
    @GetMapping("/unfinished")
    public List<Survey> getAllUnfinished() {
        return surveyService.getUnfinishedSurveys();
    }
}
