package com.fabrique.survey.repository;

import com.fabrique.survey.domain.enums.QuestionType;
import com.fabrique.survey.domain.model.Question;
import com.fabrique.survey.domain.model.Survey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql(scripts = "classpath:drop.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class SurveyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SurveyRepository repository;

    @Test
    public void saveShouldAddQuestionInQuestionsTable() {
        Survey actual = testData.survey1;
        repository.save(actual);

        Survey expected = entityManager.find(Survey.class, actual.getId());
        assertEquals(expected, actual);
    }

    public interface testData {
        Question question1 = new Question("first question", QuestionType.TEXT);
        Question question2 = new Question("second question", QuestionType.MULTIPLE);
        Question question3 = new Question("third question", QuestionType.MULTIPLE);
        Question question4 = new Question("fourth question", QuestionType.ONE);
        Survey survey1 = new Survey("first survey", "description", LocalDate.now(),
                LocalDate.of(2021, 5, 29), Arrays.asList(question1, question2));
        Survey survey2 = new Survey("second survey", "description", LocalDate.now(),
                LocalDate.of(2021, 5, 29), Arrays.asList(question3, question4));
    }
}
