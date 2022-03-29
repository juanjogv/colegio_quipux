CREATE TABLE IF NOT EXISTS user_types (
    user_type_id SERIAL PRIMARY KEY,
    user_type_name varchar (50) UNIQUE NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    user_username varchar(100) UNIQUE NOT NULL,
    user_email varchar(100) UNIQUE NOT NULL,
    user_password varchar(200) NOT NULL,
    user_type int NOT NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS gender_types (
	gender_type_id SERIAL PRIMARY KEY,
	gender_type_name varchar(100),
	is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    student_id SERIAL PRIMARY KEY,
    student_key varchar(100) UNIQUE NOT NULL,
    student_name varchar(100) NOT NULL,
    student_lastname varchar(100) NOT NUll,
    student_birth_date date NOT NULL,
    student_gender int NOT NULL,
    student_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS teachers (
    teacher_id SERIAL PRIMARY KEY,
    teacher_key varchar(100) UNIQUE NOT NULL,
    teacher_name varchar(100) NOT NULL,
    teacher_lastname varchar(100) NOT NUll,
    teacher_birth_date date NOT NULL,
    teacher_gender int NOT NULL,
    teacher_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS directives (
    directive_id SERIAL PRIMARY KEY,
    directive_key varchar(100) UNIQUE NOT NULL,
    directive_name varchar(100) NOT NULL,
    directive_lastname varchar(100) NOT NUll,
    directive_birth_date date NOT NULL,
    directive_gender int NOT NULL,
    directive_contact_numer varchar(100) NOT NUll,
    user_id int,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS teachers_subjects (
    teacher_subject_id SERIAL PRIMARY KEY,
    teacher_id int NOT NULL,
    subject_id int NOT NULL,
    grade_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS subjects (
    subject_id SERIAL PRIMARY KEY,
    subject_name varchar(100) NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS groups_subjects (
    group_subject_id SERIAL PRIMARY KEY,
    group_id int NOT NULL,
    subject_id int NOT NULL,
    teacher_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS groups (
    group_id SERIAL PRIMARY KEY,
    group_name varchar(100) NOT NUll,
    group_leader int NOT NULL,
    grade_id int NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS grades (
    grade_id SERIAL PRIMARY KEY,
    grade_name varchar(100) NOT NUll,
    grade_leader int NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS students_groups (
    student_group_id SERIAL PRIMARY KEY,
    student_id int NOT NULL,
    group_id int NOT NULL,
    enrolling_date TIMESTAMP NOT NULL,
    is_active varchar(10) DEFAULT 'Y' NOT NULL
);

CREATE TABLE IF NOT EXISTS students_scores (
    student_score_id SERIAL PRIMARY KEY,
    score int NOT NULL, 
    student_id int NOT NULL,
    teacher_id int NOT NULL,
    group_id int NOT NULL,
    subject_id int NOT NULL
);

ALTER TABLE user_types
	ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE users
    ADD CONSTRAINT user_types_users_fk
        FOREIGN KEY (user_type)
            REFERENCES user_types(user_type_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

 ALTER TABLE gender_types
	ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE students
    ADD CONSTRAINT users_students_fk
        FOREIGN KEY (user_id)
            REFERENCES users(user_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT gender_types_students_fk
        FOREIGN KEY (student_gender)
            REFERENCES gender_types(gender_type_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE teachers
    ADD CONSTRAINT users_teachers_fk
        FOREIGN KEY (user_id)
            REFERENCES users(user_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT gender_types_teachers_fk
        FOREIGN KEY (teacher_gender)
            REFERENCES gender_types(gender_type_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE directives
    ADD CONSTRAINT users_directives_fk
        FOREIGN KEY (user_id)
            REFERENCES users(user_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT gender_types_directives_fk
        FOREIGN KEY (directive_gender)
            REFERENCES gender_types(gender_type_id)
            ON DELETE SET NUll,

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE teachers_subjects
    ADD CONSTRAINT teachers_teachers_subjects_fk
        FOREIGN KEY (teacher_id)
            REFERENCES teachers(teacher_id),

    ADD CONSTRAINT subjects_teachers_subjects_fk
        FOREIGN KEY (subject_id)
            REFERENCES subjects(subject_id),

    ADD CONSTRAINT grades_teachers_subjects_fk
        FOREIGN KEY (grade_id)
            REFERENCES grades(grade_id);

ALTER TABLE subjects
	ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE groups_subjects
    ADD CONSTRAINT groups_groups_subjects_fk
        FOREIGN KEY (group_id)
            REFERENCES groups(group_id),

    ADD CONSTRAINT subjects_groups_subjects_fk
        FOREIGN KEY (subject_id)
            REFERENCES subjects(subject_id),

    ADD CONSTRAINT teachers_groups_subjects_fk
        FOREIGN KEY (teacher_id)
            REFERENCES teachers(teacher_id);

ALTER TABLE groups
    ADD CONSTRAINT teachers_groups_fk
        FOREIGN KEY (group_leader)
            REFERENCES teachers(teacher_id),

    ADD CONSTRAINT grades_groups_fk
        FOREIGN KEY (grade_id)
            REFERENCES grades(grade_id),

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE grades
    ADD CONSTRAINT teachers_grades_fk
        FOREIGN KEY (grade_leader)
            REFERENCES teachers(teacher_id),

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE students_groups
    ADD CONSTRAINT students_students_groups_fk
        FOREIGN KEY (student_id)
            REFERENCES students(student_id),

    ADD CONSTRAINT grups_students_groups_fk
        FOREIGN KEY (group_id)
            REFERENCES groups(group_id),

    ADD CONSTRAINT is_active_check
    	CHECK(
    			is_active = 'Y'
    			OR is_active = 'N'
    		);

ALTER TABLE students_scores
    ADD CONSTRAINT students_students_scores_fk
        FOREIGN KEY (student_id)
            REFERENCES students(student_id),

    ADD CONSTRAINT teachers_students_scores_fk
        FOREIGN KEY (teacher_id)
            REFERENCES teachers(teacher_id),

    ADD CONSTRAINT groups_students_scores_fk
        FOREIGN KEY (group_id)
            REFERENCES groups(group_id),

    ADD CONSTRAINT subjects_students_scores_fk
        FOREIGN KEY (subject_id)
            REFERENCES subjects(subject_id);