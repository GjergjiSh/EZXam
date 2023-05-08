INSERT INTO students (name, matnr, lastname) VALUES ('John', '12345', 'Doe');
INSERT INTO students (name, matnr, lastname) VALUES ('Jane', '67890', 'Smith');
INSERT INTO students (name, matnr, lastname) VALUES ('Bob', '24680', 'Johnson');

INSERT INTO exams (name) VALUES ('Math Quiz 1');
INSERT INTO exams (name) VALUES ('Science Quiz 1');

INSERT INTO questions (text, total_points) VALUES ('What is 2 + 2?', 5);
INSERT INTO questions (text, total_points) VALUES ('What is 1 + 1?', 5);
INSERT INTO questions (text, total_points) VALUES ('What is the chemical formula for water?', 10);
INSERT INTO questions (text, total_points) VALUES ('What is the capital city of England?', 5);

INSERT INTO exam_questions (exam_id, question_id) VALUES (1, 1);
INSERT INTO exam_questions (exam_id, question_id) VALUES (1, 2);
INSERT INTO exam_questions (exam_id, question_id) VALUES (2, 3);
INSERT INTO exam_questions (exam_id, question_id) VALUES (2, 4);