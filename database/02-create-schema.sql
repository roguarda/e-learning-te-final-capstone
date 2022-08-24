-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user, course, curricula, homework, curricula_course, student_course CASCADE;


CREATE TABLE app_user
(
    user_id    SERIAL      NOT NULL UNIQUE PRIMARY KEY,
    user_name  varchar(32) NOT NULL UNIQUE,
    password   varchar(32) NOT NULL,
    first_name varchar(32) NOT NULL,
    last_name  varchar(32) NOT NULL,
    role       varchar(32) NOT NULL,
    is_teacher boolean,
    is_student boolean,
    salt       varchar(255) NOT NULL
);



CREATE TABLE curricula
(
    curricula_id      SERIAL        NOT NULL UNIQUE PRIMARY KEY,
    curricula_name    VARCHAR(55)   not null,
    daily_instruction VARCHAR(1000) NOT NULL,
    daily_homework    VARCHAR(1000) NOT NULL
--     course_id          SERIAL NOT   NULL,
--     FOREIGN KEY (course_id) REFERENCES course (course_id)
);


CREATE TABLE course
(
    course_id          SERIAL       NOT NULL UNIQUE PRIMARY KEY,
    course_name        VARCHAR(55)  NOT NULL,
    teacher_id         INT,
    course_description varchar(255) NOT NULL,
    difficulty         varchar(10)  NOT NULL,
    cost               varchar(10),
--     curricula_id       INT,
    FOREIGN KEY (teacher_id) REFERENCES app_user (user_id)
--     foreign key (curricula_id) REFERENCES curricula (curricula_id)

);

CREATE TABLE curricula_course
(
    course_id    SERIAL NOT NULL,
    curricula_id INT    NOT NULL,

    CONSTRAINT FK_curricula_course FOREIGN KEY (course_id) REFERENCES course (course_id),
    CONSTRAINT FK_course_curricula FOREIGN KEY (curricula_id) REFERENCES curricula (curricula_id)

);
CREATE TABLE student_course
(
    student_id int NOT NULL,
    course_id  int NOT NULL,
    PRIMARY KEY (student_id, course_id)

);
CREATE TABLE homework
(
    homework_id           SERIAL        NOT NULL UNIQUE PRIMARY KEY,
    homework_name         VARCHAR(20)   NOT NULL,
    homework_introduction VARCHAR(140)  NOT NULL,
    homework_description  VARCHAR(1000) NOT NULL,
    curricula_id          INT,
    course_id             INT,
    student_id            INT,
    teacher_id            INT,
    status                VARCHAR(20),
    is_completed          BOOLEAN,
    grade                 INT,
    teacher_feedback      VARCHAR(1000),

    FOREIGN KEY (teacher_id) REFERENCES app_user (user_id),
    FOREIGN KEY (student_id) REFERENCES app_user (user_id),
    FOREIGN KEY (curricula_id) REFERENCES curricula (curricula_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)


);

CREATE TABLE student_homework
(
    student_id  int NOT NULL,
    homework_id int NOT NULL,
    PRIMARY KEY (student_id, homework_id)

);

--student - course FKS

ALTER TABLE student_course
    Add constraint fk_student_course_student
        foreign key (student_id) references app_user (user_id);

ALTER TABLE student_course
    Add constraint fk_student_course_course
        foreign key (course_id) references course (course_id);


-- STUDENT - HOMEWORK FKS
ALTER TABLE student_homework
    Add constraint fk_student_homework_student
        foreign key (student_id) references app_user (user_id);

ALTER TABLE student_homework
    Add constraint fk_student_homework_homework
        foreign key (homework_id) references homework (homework_id);


COMMIT;