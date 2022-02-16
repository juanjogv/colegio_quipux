
CREATE TYPE YN_ANSWER AS ENUM ('Y', 'N');
CREATE TYPE GENDER AS ENUM ('M', 'F', 'O');

CREATE TABLE IF NOT EXISTS Users (
    user_id SERIAL PRIMARY KEY,
    user_nickname varchar(100) UNIQUE NOT NULL,
    user_email varchar(100) UNIQUE NOT NULL,
    user_password varchar(200) NOT NULL,
    user_type int NOT NULL,
    register_date TIMESTAMP NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS UserTypes (
    user_type_id SERIAL PRIMARY KEY,
    user_type_name varchar (50) UNIQUE NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Students (
    student_id SERIAL PRIMARY KEY,
    student_key varchar(100) UNIQUE NOT NULL,
    student_name varchar(100) NOT NULL,
    student_lastname varchar(100) NOT NUll,
    student_birth_date date NOT NULL,
    student_gender GENDER NOT NULL,
    student_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Teachers (
    teacher_id SERIAL PRIMARY KEY,
    teacher_key varchar(100) UNIQUE NOT NULL,
    teacher_name varchar(100) NOT NULL,
    teacher_lastname varchar(100) NOT NUll,
    teacher_birth_date date NOT NULL,
    teacher_gender GENDER NOT NULL,
    teacher_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Directives (
    directive_id SERIAL PRIMARY KEY,
    directive_key varchar(100) UNIQUE NOT NULL,
    directive_name varchar(100) NOT NULL,
    directive_lastname varchar(100) NOT NUll,
    directive_birth_date date NOT NULL,
    directive_gender GENDER NOT NULL,
    directive_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS TeachersSubjects (
    teacher_subject_id SERIAL PRIMARY KEY,
    teacher_id int NOT NULL,
    subject_id int NOT NULL,
    grade_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS Subjects (
    subject_id SERIAL PRIMARY KEY,
    subject_name varchar(100) NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS GroupsSubjects (
    group_subject_id SERIAL PRIMARY KEY,
    group_id int NOT NULL,
    subject_id int NOT NULL,
    teacher_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS Groups (
    group_id SERIAL PRIMARY KEY,
    group_name varchar(100) NOT NUll,
    group_leader int NOT NULL,
    grade_id int NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Grades (
    grade_id SERIAL PRIMARY KEY,
    grade_name varchar(100) NOT NUll,
    grade_leader int NOT NULL,
    is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS StudentsGroups (
    student_group_id SERIAL PRIMARY KEY,
    student_id int NOT NULL,
    group_id int NOT NULL,
    enrolling_date TIMESTAMP NOT NULL,
    is_current_group YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS StudentsScores (
    student_score_id SERIAL PRIMARY KEY,
    score int NOT NULL,
    student_id int NOT NULL,
    teacher_id int NOT NULL,
    group_id int NOT NULL,
    subject_id int NOT NULL
);

ALTER TABLE Users
    ADD CONSTRAINT usertypes_users_fk
        FOREIGN KEY (user_type)
            REFERENCES UserTypes(user_type_id)
            ON DELETE SET NUll;

ALTER TABLE Students
    ADD CONSTRAINT users_students_fk
        FOREIGN KEY (user_id)
            REFERENCES Users(user_id)
            ON DELETE SET NUll;

ALTER TABLE Teachers
    ADD CONSTRAINT users_teachers_fk
        FOREIGN KEY (user_id)
            REFERENCES Users(user_id)
            ON DELETE SET NUll;

ALTER TABLE Directives
    ADD CONSTRAINT users_directives_fk
        FOREIGN KEY (user_id)
            REFERENCES Users(user_id)
            ON DELETE SET NUll;


ALTER TABLE TeachersSubjects
    ADD CONSTRAINT teachers_teacherssubjects_fk
        FOREIGN KEY (teacher_id)
            REFERENCES Teachers(teacher_id),

    ADD CONSTRAINT subjects_teacherssubjects_fk
        FOREIGN KEY (subject_id)
            REFERENCES Subjects(subject_id),

    ADD CONSTRAINT grades_teacherssubjects_fk
        FOREIGN KEY (grade_id)
            REFERENCES Grades(grade_id);

ALTER TABLE GroupsSubjects
    ADD CONSTRAINT groups_groupssubjects_fk
        FOREIGN KEY (group_id)
            REFERENCES Groups(group_id),

    ADD CONSTRAINT subjects_groupssubjects_fk
        FOREIGN KEY (subject_id)
            REFERENCES Subjects(subject_id),

    ADD CONSTRAINT teachers_groupssubjects_fk
        FOREIGN KEY (teacher_id)
            REFERENCES Teachers(teacher_id);

ALTER TABLE Groups
    ADD CONSTRAINT teachers_groups_fk
        FOREIGN KEY (group_leader)
            REFERENCES Teachers(teacher_id),

    ADD CONSTRAINT grades_groups_fk
        FOREIGN KEY (grade_id)
            REFERENCES Grades(grade_id);

ALTER TABLE Grades
    ADD CONSTRAINT teachers_grades_fk
        FOREIGN KEY (grade_leader)
            REFERENCES Teachers(teacher_id);

ALTER TABLE StudentsGroups
    ADD CONSTRAINT students_studentsgroups_fk
        FOREIGN KEY (student_id)
            REFERENCES Students(student_id),

    ADD CONSTRAINT grups_studentsgroups_fk
        FOREIGN KEY (group_id)
            REFERENCES Groups(group_id);

ALTER TABLE StudentsScores
    ADD CONSTRAINT students_studentsscores_fk
        FOREIGN KEY (student_id)
            REFERENCES Students(student_id),

    ADD CONSTRAINT teachers_studentsscores_fk
        FOREIGN KEY (teacher_id)
            REFERENCES Teachers(teacher_id),

    ADD CONSTRAINT groups_studentsscores_fk
        FOREIGN KEY (group_id)
            REFERENCES Groups(group_id),

    ADD CONSTRAINT subjects_studentsscores_fk
        FOREIGN KEY (subject_id)
            REFERENCES Subjects(subject_id);