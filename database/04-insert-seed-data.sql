-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES ('GARY','Pasword1', 'gary', 'thanks', 'teacher', true, false, 'FGHJKLPIDFJPS0255');


insert into course (course_name, teacher_id, course_description, difficulty, cost)
values ('course', 1, 'description', 'mid', 'FREE');


COMMIT;