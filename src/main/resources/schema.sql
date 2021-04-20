CREATE TABLE IF NOT EXISTS surveys(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    description varchar(255),
    created_date TIMESTAMP NOT NULL,
    finished_date TIMESTAMP NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS questions(
    id BIGINT NOT NULL AUTO_INCREMENT,
    question VARCHAR(255) NOT NULL,
    type VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS surveys_questions(
    survey_id BIGINT NOT NULL,
    question_id BIGINT NOT NULL,
    PRIMARY KEY (survey_id, question_id),
    CONSTRAINT FK_surveys_questions_surveys FOREIGN KEY (survey_id) REFERENCES surveys (id),
    CONSTRAINT FK_surveys_questions_questions FOREIGN KEY (question_id) REFERENCES questions (id)
);