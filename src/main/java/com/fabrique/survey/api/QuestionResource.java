package com.fabrique.survey.api;

import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.service.QuestionService;
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

import static com.fabrique.survey.api.QuestionResource.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
@Api(value = "Questions", tags = "Questions")
@PreAuthorize("hasRole('ADMIN')")
public class QuestionResource {

    public static final String BASE_URL = "api/questions";

    private final QuestionService questionService;

    public QuestionResource(QuestionService service) {
        this.questionService = service;
    }

    @ApiOperation(value = "Save question")
    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question) {
        questionService.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all questions")
    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @ApiOperation(value = "Delete question")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        questionService.deleteById(id);
    }
}
