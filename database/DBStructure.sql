
CREATE TYPE YN_ANSWER AS ENUM ('Y', 'N');
CREATE TYPE GENDER AS ENUM ('Male', 'Female', 'Other');
CREATE TYPE SCORE AS ENUM (1, 2, 3, 4, 5)

CREATE TABLE IF NOT EXISTS Users (
	user_id int SERIAL PRIMARY KEY,
	user_nickname varchar(100) UNIQUE NOT NULL,
	user_email varchar(100) UNIQUE NOT NULL,
	user_password varchar(200) NOT NULL,
	user_type int NOT NULL,
	register_date TIMESTAMP NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS UserTypes (
	user_type_id int SERIAL PRIMARY KEY,
	user_type_name varchar (50) UNIQUE NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Students (
	student_id int SERIAL PRIMARY KEY,
	student_key varchar(100) UNIQUE NOT NULL,
	student_name varchar(100) NOT NULL,
	studen_lastname varchar(100) NOT NUll,
	student_birth_date date NOT NULL,
	student_gender GENDER NOT NULL,
	student_contact_numer varchar(100) NOT NUll,
	user_id int,
	register_date TIMESTAMP NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Teachers (
	teacher_id int SERIAL PRIMARY KEY,
	teacher_key varchar(100) UNIQUE NOT NULL,
	teacher_name varchar(100) NOT NULL,
	studen_lastname varchar(100) NOT NUll,
	teacher_birth_date date NOT NULL,
	teacher_gender GENDER NOT NULL,
	teacher_contact_numer varchar(100) NOT NUll,
	user_id int,
	register_date TIMESTAMP NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Directives (
	directive_id int SERIAL PRIMARY KEY,
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
	teacher_id int NOT NULL,
	subject_id int NOT NULL,
	grade_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS Subjects (
	subject_id int SERIAL PRIMARY KEY,
	subject_name varchar(100) NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS GroupsSubjects (
	group_id int NOT NULL,
	subject_id int NOT NULL,
	teacher_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS Groups (
	group_id int SERIAL PRIMARY KEY,
	group_name varchar(100) NOT NUll,
	group_leader int NOT NULL,
	id_grade int NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS Grades (
	grade_id int SERIAL PRIMARY KEY,
	grade_name varchar(100) NOT NUll,
	grade_leader int NOT NULL,
	is_active YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS StudentsGroups (
	student_id int NOT NULL,
	group_id int NOT NULL,
	enrolling_date TIMESTAMP NOT NULL,
	is_current_group YN_ANSWER NOT NULL DEFAULT 'Y'
);

CREATE TABLE IF NOT EXISTS StudentsScores (
	student_score_id int SERIAL PRIMARY KEY,
	score SCORE NOT NULL,
	student_id int NOT NULL,
	teacher_id int NOT NULL,
	group_id int NOT NULL,
	subject_id int NOT NULL
);