INSERT INTO questions (question, type) VALUES ('first question', 'ONE');
INSERT INTO questions (question, type) VALUES ('second question', 'MULTIPLE');
INSERT INTO questions (question, type) VALUES ('third question', 'TEXT');

INSERT INTO surveys (name, description, created_date, finished_date) VALUES ('first survey', 'one question survey', now(), '2021-05-05');
INSERT INTO surveys (name, description, created_date, finished_date) VALUES ('second survey', 'two question survey', now(), '2021-05-05');
INSERT INTO surveys (name, description, created_date, finished_date) VALUES ('third survey', 'three question survey', now(), '2021-05-05');

INSERT INTO surveys_questions(survey_id, question_id) VALUES (1,1);
INSERT INTO surveys_questions(survey_id, question_id) VALUES (2,1);
INSERT INTO surveys_questions(survey_id, question_id) VALUES (2,2);
INSERT INTO surveys_questions(survey_id, question_id) VALUES (3,1);
INSERT INTO surveys_questions(survey_id, question_id) VALUES (3,2);
INSERT INTO surveys_questions(survey_id, question_id) VALUES (3,3);

INSERT INTO users (first_name, last_name) VALUES ('test', 'user');
