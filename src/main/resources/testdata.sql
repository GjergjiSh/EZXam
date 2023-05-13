-- Insert data into the professors table
INSERT INTO professors (name, lastname) VALUES ('Professor 1', 'Lastname 1');
INSERT INTO professors (name, lastname) VALUES ('Professor 2', 'Lastname 2');
INSERT INTO professors (name, lastname) VALUES ('Professor 3', 'Lastname 3');

-- Insert data into the subjects table
INSERT INTO subjects (name, professor_id) VALUES ('Subject 1', 1);
INSERT INTO subjects (name, professor_id) VALUES ('Subject 2', 2);
INSERT INTO subjects (name, professor_id) VALUES ('Subject 3', 3);



-- Insert dummy students
INSERT INTO students (name, matnr, lastname) VALUES
                                                 ('Student 1', '123456', 'Lastname 1'),
                                                 ('Student 2', '234567', 'Lastname 2'),
                                                 ('Student 3', '345678', 'Lastname 3');

-- Insert dummy topics
INSERT INTO topics (subject_id, name) VALUES
                                          (1, 'Topic 1'),
                                          (1, 'Topic 2'),
                                          (2, 'Topic 3'),
                                          (3, 'Topic 4'),
                                          (3, 'Topic 5');

-- Insert dummy questions
INSERT INTO questions (description, text, points, topic_id) VALUES
                                                                ('Description 1', 'Text 1', 1.0, 1),
                                                                ('Description 2', 'Text 2', 2.0, 1),
                                                                ('Description 3', 'Text 3', 3.0, 2),
                                                                ('Description 4', 'Text 4', 4.0, 3),
                                                                ('Description 5', 'Text 5', 5.0, 4);

-- Insert dummy criterias
INSERT INTO criterias (question_id, name, description, weight)
VALUES (1, 'Criteria 1', 'This is the description for criteria 1', 0.5);

INSERT INTO criterias (question_id, name, description, weight)
VALUES (1, 'Criteria 2', 'This is the description for criteria 2', 0.3);

INSERT INTO criterias (question_id, name, description, weight)
VALUES (2, 'Criteria 1', 'This is the description for criteria 1', 0.4);

INSERT INTO criterias (question_id, name, description, weight)
VALUES (2, 'Criteria 2', 'This is the description for criteria 2', 0.6);

INSERT INTO criterias (question_id, name, description, weight)
VALUES (3, 'Criteria 1', 'This is the description for criteria 1', 0.7);

INSERT INTO criterias (question_id, name, description, weight)
VALUES (3, 'Criteria 2', 'This is the description for criteria 2', 0.2);


-- Insert dummy exams
INSERT INTO exams (subject_id, student_id) VALUES
                                               (1, 1),
                                               (2, 2),
                                               (3, 3);
