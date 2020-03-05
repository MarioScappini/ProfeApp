CREATE TABLE teacher(
    teacher_id UUID NOT NULL PRIMARY KEY UNIQUE,
    firstName text NOT NULL,
    lastName text NOT NULL,
    rating numeric,
    teacher_description text,
    nationality text NOT NULL,
    currentResidence text NOT NULL,
    subject text[]
);

