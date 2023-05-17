-- Add dummy data to the professors table
INSERT INTO professors (name, lastname) VALUES
                                            ('John', 'Doe'),
                                            ('Jane', 'Smith');

-- Add dummy data to the subjects table
INSERT INTO subjects (name, professor_id) VALUES
                                              ('Mathematics', 1),
                                              ('Physics', 2);

-- Add dummy data to the exam_sessions table
INSERT INTO exam_sessions (subject_id, finished, date) VALUES
                                                           (1, true, '2023-05-01'),
                                                           (2, false, '2023-05-02');

-- Add dummy data to the topics table
INSERT INTO topics (name, subject_id) VALUES
                                          ('Algebra', 1),
                                          ('Mechanics', 2);

-- Add dummy data to the questions table
INSERT INTO questions (description, text, points, topic_id) VALUES
                                                                ('Question 1', 'What is the square root of 16?', 5.0, 1),
                                                                ('Question 2', 'What is the acceleration due to gravity?', 10.0, 2);

-- Add dummy data to the criterias table
INSERT INTO criterias (question_id, name, description, weight) VALUES
                                                                   (1, 'Accuracy', 'How accurate is the answer?', 0.5),
                                                                   (2, 'Explanation', 'How well is the concept explained?', 0.7);

-- Add dummy data to the students table
INSERT INTO students (name, matnr, lastname) VALUES
                                                 ('Student 1', '123456', 'Lastname 1'),
                                                 ('Student 2', '234567', 'Lastname 2'),
                                                 ('Student 3', '345678', 'Lastname 3');

-- Add dummy data to the exams table
INSERT INTO exams (exam_session_id, student_id, duration) VALUES
                                                              (1, 1, 120),
                                                              (2, 2, 90);

-- Add dummy data to the answers table
INSERT INTO answers (exam_id, text, description, points, achieved_points) VALUES
                                                                                           (1, 'Answer 1', 'Answer description 1', 5.0, 4.5),
                                                                                           (1, 'Answer 2', 'Answer description 2', 10.0, 8.0),
                                                                                           (2, 'Answer 3', 'Answer description 3', 5.0, 4.0),
                                                                                           (2, 'Answer 4', 'Answer description 4', 10.0, 9.0);

-- Add dummy data to the answer_criterias table
INSERT INTO answer_criterias (answer_id, name, description, weight, met) VALUES
                                                                             (1, 'Criteria 1', 'Criteria description 1', 0.5, true),
                                                                             (1, 'Criteria 2', 'Criteria description 2', 0.7, false),
                                                                             (2, 'Criteria 1', 'Criteria description 1', 0.5, true),
                                                                             (2, 'Criteria 2', 'Criteria description 2', 0.7, true);