-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES ('GARY','Pasword1', 'gary', 'thanks', 'teacher', true, false, 'Lp5Ey8FccIyx6Wo+K9EJSAkXLXF95pfyjXUhn4m89nhFKeLNb8Z2MNENcYAHFbIUM+UGawKLLenh7+O6xdBYbrZK+h5nivf3yU4uiOFBFCzXCVLy3RPhlqrNQ8RpUmdHgaZl7n0pXQPoTruSibst9UbQHiFHQhi6Pck6ygeouFA=
'),
       ('Micat','Pasword1', 'micaela', 'teacher', 'teacher', true, false, 'Lp5Ey8FccIyx6Wo+K9EJSAkXLXF95pfyjXUhn4m89nhFKeLNb8Z2MNENcYAHFbIUM+UGawKLLenh7+O6xdBYbrZK+h5nivf3yU4uiOFBFCzXCVLy3RPhlqrNQ8RpUmdHgaZl7n0pXQPoTruSibst9UbQHiFHQhi6Pck6ygeouFA=
'),
       ('Michelle','Pasword1', 'michelle', 'student', 'student', false, true, 'Lp5Ey8FccIyx6Wo+K9EJSAkXLXF95pfyjXUhn4m89nhFKeLNb8Z2MNENcYAHFbIUM+UGawKLLenh7+O6xdBYbrZK+h5nivf3yU4uiOFBFCzXCVLy3RPhlqrNQ8RpUmdHgaZl7n0pXQPoTruSibst9UbQHiFHQhi6Pck6ygeouFA=
'),
       ('John','Pasword1', 'john', 'student', 'student', false, true, 'Lp5Ey8FccIyx6Wo+K9EJSAkXLXF95pfyjXUhn4m89nhFKeLNb8Z2MNENcYAHFbIUM+UGawKLLenh7+O6xdBYbrZK+h5nivf3yU4uiOFBFCzXCVLy3RPhlqrNQ8RpUmdHgaZl7n0pXQPoTruSibst9UbQHiFHQhi6Pck6ygeouFA=
'),
       ('Chris','Pasword1', 'christopher', 'student', 'student', false, true, 'Lp5Ey8FccIyx6Wo+K9EJSAkXLXF95pfyjXUhn4m89nhFKeLNb8Z2MNENcYAHFbIUM+UGawKLLenh7+O6xdBYbrZK+h5nivf3yU4uiOFBFCzXCVLy3RPhlqrNQ8RpUmdHgaZl7n0pXQPoTruSibst9UbQHiFHQhi6Pck6ygeouFA=
');


insert into course (course_name, teacher_id, course_description, difficulty, cost)
values ('course', 1, 'description', 'mid', 'FREE'),
       ('fullstack', 2, 'principles of coding', 'mid', 'FREE'),
       ('testing', 2, 'testing automation', 'high', 'FREE'),
       ('SQL', 1, 'database ', 'mid', 'FREE'),
       ('Frontend Development', 1, 'Javascript basics', 'mid', 'FREE');


insert into student_course (student_id, course_id)
values (1,1),
       (1,2),
       (2,1),
       (2,2),
       (3,1),
       (3,2);

COMMIT;