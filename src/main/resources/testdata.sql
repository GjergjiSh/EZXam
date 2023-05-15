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
(2, 'Explanation', 'How well is the concept explained?', 0.7)