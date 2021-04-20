package com.fabrique.survey.repository;

import com.fabrique.survey.domain.enums.QuestionType;
import com.fabrique.survey.domain.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql(scripts = "classpath:drop.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class QuestionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuestionRepository repository;

    @Test
    public void saveShouldAddQuestionInQuestionsTable() {
        Question actual = new Question("simple question", QuestionType.TEXT);

        repository.save(actual);

        Question expected = entityManager.find(Question.class, actual.getId());
        assertEquals(expected, actual);
    }
}