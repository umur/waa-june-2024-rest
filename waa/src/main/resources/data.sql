CREATE
DATABASE IF NOT EXISTS `waa`;

INSERT INTO course (id, name, code)
VALUES (1, 'WAA', 'CS545'),
       (2, 'EA', 'CS544');

INSERT INTO student (id, first_name, last_name, email, major, gpa)
VALUES (1, 'FStudent1', 'LStudent1', 'student1@mail.com', 'CS', 4.0),
       (2, 'FStudent2', 'LStudent2', 'student2@mail.com', 'Art', 3.0)