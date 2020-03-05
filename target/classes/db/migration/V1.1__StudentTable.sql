CREATE TABLE student(
    student_id UUID NOT NULL PRIMARY KEY UNIQUE,
    name text NOT NULL,
    lastName text NOT NULL,
    email text NOT NULL,
    photo_url text
);