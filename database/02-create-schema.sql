-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS curricula;
DROP TABLE IF EXISTS homework;


CREATE TABLE app_user
(
    user_id    SERIAL       NOT NULL UNIQUE PRIMARY KEY,
    user_name  varchar(32)  NOT NULL UNIQUE,
    password   varchar(32)  NOT NULL,
    first_name varchar(32)  NOT NULL,
    last_name  varchar(32)  NOT NULL,
    role       varchar(32)  NOT NULL,
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

);


CREATE TABLE course
(
    course_id          SERIAL       NOT NULL UNIQUE PRIMARY KEY,
    course_name        VARCHAR(55)  NOT NULL,
    teacher_id         INT,
    course_description varchar(255) NOT NULL,
    difficulty         varchar(10)  NOT NULL,
    cost               varchar(10),
    student_id         INT,
    curricula_id       INT,
    FOREIGN KEY (teacher_id) REFERENCES app_user (user_id),
    FOREIGN KEY (student_id) REFERENCES app_user (user_id),
    foreign key (curricula_id) REFERENCES curricula (curricula_id)

);

CREATE TABLE homework
(
    homework_id      SERIAL NOT NULL UNIQUE PRIMARY KEY,
    curricula_id     INT    NOT NULL,
    course_id        INT    NOT NULL,
    student_id       INT    NOT NULL,
    teacher_id       INT    NOT NULL,
    COMPLETED        BOOLEAN,
    GRADE            INT,
    teacher_feedback VARCHAR(1000),

    FOREIGN KEY (teacher_id) REFERENCES app_user (user_id),
    FOREIGN KEY (student_id) REFERENCES app_user (user_id),
    FOREIGN KEY (curricula_id) REFERENCES curricula (curricula_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)


);

COMMIT;