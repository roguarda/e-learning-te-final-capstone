-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES ('GARY','Pasword1', 'gary', 'thanks', 'teacher', true, false, 'FGHJKLPIDFJPS0255'),
       ('Micat','Pasword1', 'micaela', 'teacher', 'teacher', true, false, 'FGHJK112dfLPIDFJPS0255'),
       ('Michelle','Pasword1', 'michelle', 'student', 'student', false, true, 'FG5HJK112dfLPIDFJPS0255'),
       ('John','Pasword1', 'john', 'student', 'student', false, true, 'FGHJK112dfLPIDFJPA5S0255'),
       ('Chris','Pasword1', 'christopher', 'student', 'student', false, true, 'FGHJK112dfLPIDFJPS0255');


insert into course (course_name, teacher_id, course_description, difficulty, cost)
values ('course', 1, 'description', 'mid', 'FREE'),
       ('fullstack', 2, 'principles of coding', 'mid', 'FREE');

insert into student_course (student_id, course_id)
values (1,1),
       (1,2),
       (2,1),
       (2,2),
       (3,1),
       (3,2);

COMMIT;