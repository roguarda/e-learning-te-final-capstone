-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, first_name, last_name, role, is_teacher, is_student, salt)
VALUES ('teacher', '5T/az89vuaZSAkdeIckgFQ==', 'teacher', 'teacher', 'teacher', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('GARY', '5T/az89vuaZSAkdeIckgFQ==', 'gary', 'thanks', 'teacher', true, false,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Micat', '5T/az89vuaZSAkdeIckgFQ==', 'micaela', 'teacher', 'teacher', true, false,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('DaltonDrummond', '5T/az89vuaZSAkdeIckgFQ==', 'Dalton', 'Drummond', 'teacher', true, false,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('student', '5T/az89vuaZSAkdeIckgFQ==', 'student', 'student', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Michelle', '5T/az89vuaZSAkdeIckgFQ==', 'michelle', 'student', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Diaz', '5T/az89vuaZSAkdeIckgFQ==', 'Melissa', 'Diaz', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('John', '5T/az89vuaZSAkdeIckgFQ==', 'john', 'student', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Shannawatson', '5T/az89vuaZSAkdeIckgFQ==', 'Shanna', 'Watson', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Laurel', '5T/az89vuaZSAkdeIckgFQ==', 'Laurel', 'Regan', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('StefaniaEscobar', '5T/az89vuaZSAkdeIckgFQ==', 'Stefania', 'Escobar', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA='),
       ('Chris', '5T/az89vuaZSAkdeIckgFQ==', 'christopher', 'student', 'student', false, true,'cfmt6e0SKh31a3RwZFVsmHTlIh0Eb7D1MJ1m1s0hQ5d9zcZoFXx8ZjFRNob0gzgh+RCBwFvDZzt6dLGLyVs4USOCcs/iOuqIBIH1sGjrZGDJ7vk8zkpOx84Pak0uEfEZ7TPJNJ4TLobaiQWbz7oGm0WO6hUSd0mdgjbf7PLjMJA=');

insert into course (course_name, teacher_id, course_description, difficulty, cost)
values ('course', 1, 'description', 'mid', 'FREE'),
       ('fullstack', 2, 'principles of coding', 'mid', 'FREE'),
       ('testing', 2, 'testing automation', 'high', 'FREE'),
       ('SQL', 1, 'database ', 'mid', 'FREE'),
       ('Frontend Development', 1, 'Javascript basics', 'mid', 'FREE');


insert into student_course (student_id, course_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2);

insert into curricula(curricula_name, daily_instruction, daily_homework)
values ('Java', 'Objects', 'create a java project'),
       ('Javascript', 'functions', 'create a pop-up message'),
       ('HTML', 'basic concepts', 'create a simple web page'),
       ('SQL', 'DML', 'write queries for different scenarios');

COMMIT;