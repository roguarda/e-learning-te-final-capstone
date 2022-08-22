-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
('micapesado', 'micaela123', 'Micaela', 'Pesado', 'student', false, true, 'contraseña' );

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
('malemetallo', 'malena123', 'malena', 'Metallo','student', false, true, 'contraseña');

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
('roguarda', 'rocio123', 'Rocío', 'Guarda', 'student', false, true, 'contraseña');

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
('teacher 1', 'teacher1', 'teacher', 'one', 'teacher', true, false, 'contraseña');

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
    ('teacher 2', 'teacher2', 'teacher', 'two', 'teacher', true, false, 'contraseña');

INSERT INTO app_user
(user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES
    ('teacher 3', 'teacher3', 'teacher', 'three', 'teacher', true, false, 'contraseña');

insert into course
( course_name, teacher_id, course_description, difficulty, cost, student_id, curricula_id);
VALUES
('manual testing', 1, 'In this course you will learn how to deal with QA and testing problems', 'high', '0', 1, 1)
COMMIT;