-- Add dummy data to the users table
INSERT INTO users (username, password, user_role)
VALUES ('test1', 'test1', 0),
       ('test2', 'test2', 0);

-- Add dummy data to the professors table
INSERT INTO professors (name, lastname, user_id)
VALUES ('John', 'Doe', 1),
       ('Jane', 'Smith', 2);

-- Add dummy data to the subjects table
INSERT INTO subjects (name, professor_id)
VALUES ('Mathematics', 1),
       ('Physics', 2);

-- Add dummy data to the exam_sessions table
INSERT INTO exam_sessions (subject_id, finished, date)
VALUES (1, true, '2023-05-01'),
       (2, false, '2023-05-02');

-- Add dummy data to the topics table
INSERT INTO topics (name, subject_id)
VALUES ('Algebra', 1),
       ('Geometry', 1),
       ('Mechanics', 2);

-- Add dummy data to the questions table
INSERT INTO questions (description, text, points, topic_id)
VALUES ('Question 1', 'What is the square root of 16?', 5.0, 1),
       ('Question 2', 'What is the acceleration due to gravity?', 10.0, 3),
       ('Question 3', 'Which number is equivalent to 3^(4)÷3^(2)?', 4.0, 1),
       ('Question 4', 'What is the area of a circle with a diameter of 16?', 3, 2);

-- Add dummy data to the criterias table
INSERT INTO criterias (question_id, name, description, weight)
VALUES (1, 'Accuracy', 'How accurate is the answer?', 0.5),
       (1, 'Explanation', 'How well is the concept explained?', 0.4),
       (3, 'Explanation', 'How well is the concept explained?', 0.5),
       (4, 'Explanation', 'How well is the concept explained?', 0.6),
       (4, 'Accuracy', 'How accurate was him?', 0.4),
       (2, 'Explanation', 'How well is the concept explained?', 0.7);

-- Add dummy data to the students table
INSERT INTO students (name, matnr, lastname)
VALUES ('Student 1', '123456', 'Lastname 1'),
       ('Student 2', '234567', 'Lastname 2'),
       ('Student 3', '345678', 'Lastname 3'),
       ('Student 4', '456789', 'Lastname 4');

-- Add dummy data to the exams table
INSERT INTO exams (exam_session_id, student_id, duration, grade)
VALUES (1, 1, 120, 1.0),
       (1, 3, 120, 1.7),
       (2, 2, 90, 2.7);

-- Add dummy data to the answers table
INSERT INTO answers (exam_id, question, text, description, points, achieved_points)
VALUES (1, 'What is the square root of 16?', 'Answer 1', 'Answer description 1', 5.0, 4.5),
       (1, 'How old are you?', 'Answer 2', 'Answer description 2', 10.0, 8.0),
       (2, 'Are you ok?', 'Answer 3', 'Answer description 3', 5.0, 4.0),
       (2, 'Why should I promote you?', 'Answer 4', 'Answer description 4', 10.0, 9.0);

-- Add dummy data to the answer_criterias table
INSERT INTO answer_criterias (answer_id, name, description, weight, met)
VALUES (1, 'Criteria 1', 'Criteria description 1', 0.5, true),
       (1, 'Criteria 2', 'Criteria description 2', 0.7, false),
       (2, 'Criteria 1', 'Criteria description 1', 0.5, true),
       (2, 'Criteria 2', 'Criteria description 2', 0.7, true);


-- TRIGGERS
-- If an exam was started, but never finished, when finishing the session the exam will be removed
drop trigger if exists deleteSessionUnfinishedExams;
CREATE TRIGGER deleteSessionUnfinishedExams
    BEFORE UPDATE
    ON exam_sessions
    FOR EACH ROW
    DELETE
    from exams
    WHERE NEW.finished = true
      and exams.exam_session_id = NEW.id
      and exams.grade = 0;


drop trigger if exists createSessionAnalysis;
create trigger createSessionAnalysis
    AFTER INSERT
    on exam_sessions
    for each row
    insert into exam_session_analysis(exam_session_id, average_grade, fail, highest_grade, number_of_participants, pass)
    values (NEW.id, 0, 0.0, 0.0, 0, 0);


drop trigger if exists updateAnalysis;
CREATE TRIGGER updateAnalysis
       AFTER UPDATE
       ON exams
       FOR EACH ROW
       UPDATE exam_session_analysis
       set exam_session_analysis.exam_session_id=NEW.exam_session_id,
           exam_session_analysis.average_grade=(select avg(grade)
                                                from exams
                                                WHERE exams.exam_session_id = NEW.exam_session_id
                                                  and exams.grade >= 1.0),
           exam_session_analysis.fail=
                  (SELECT COUNT(exams.student_id)
                   FROM exams
                               join exam_sessions on exam_sessions.id = exams.exam_session_id
                   WHERE exams.exam_session_id = NEW.exam_session_id
                     and exams.grade > 4.0),
           exam_session_analysis.highest_grade=
                  (select MIN(grade)
                   from exams
                   WHERE exams.exam_session_id = NEW.exam_session_id
                     and exams.grade >= 1.0),
           exam_session_analysis.number_of_participants=
                  (SELECT COUNT(exams.student_id)
                   FROM exams
                               join exam_sessions on exam_sessions.id = exams.exam_session_id
                   WHERE exams.exam_session_id = NEW.exam_session_id
                     and grade >= 1.0),
           exam_session_analysis.pass=
                  (SELECT COUNT(exams.student_id)
                   FROM exams
                               join exam_sessions on exam_sessions.id = exams.exam_session_id
                   WHERE exams.exam_session_id = NEW.exam_session_id
                     and exams.grade < 4.0
                     and exams.grade >= 1.0)
       where exam_session_analysis.exam_session_id = NEW.exam_session_id;

-- When a session is over, adapt grades to average
-- CREATE TRIGGER adaptGradesToAverage
--     AFTER UPDATE
--     ON exam_sessions
--     FOR EACH ROW
--     IF 2.0 < (select avg(exams.grade)
--               from exams
--               WHERE exams.exam_session_id = NEW.id)
--     THEN
--     UPDATE exams
--     set exams.grade=exams.grade - 0.5
--     WHERE exams.exam_session_id = NEW.id
--       and exams.grade > 1.6;
--     End IF;

-- CREATE TRIGGER adaptGradesToAverage
--     AFTER UPDATE
--     ON exam_sessions
--     FOR EACH ROW
--
--     UPDATE exams
--     set exams.grade=exams.grade - 0.5
--     WHERE exams.exam_session_id = NEW.id
--       and exams.grade > 1.6
--       and 2.0 < (select avg(grade)
--     WHERE exams.exam_session_id = NEW.id);

-- DROP TRIGGER IF EXISTS adaptGradesToAverage;
-- CREATE TRIGGER adaptGradesToAverage
--        AFTER UPDATE
--        ON exam_sessions
--        FOR EACH ROW
--     BEGIN
--         select avg(exams.grade)
--         into @averageGrade
--         from exams
--         WHERE exams.exam_session_id = NEW.id
--           and NEW.finished = true;
--         UPDATE exams
--         set exams.grade=exams.grade - 0.5
--         WHERE exams.exam_session_id = NEW.id
--             and NEW.finished = true
--             and exams.grade > 1.6;
--             and 2.0 < @averageGrade;
--     end;


-- delimiter ;