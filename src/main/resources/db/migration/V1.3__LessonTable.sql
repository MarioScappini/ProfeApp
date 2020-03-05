CREATE TABLE lesson(
    lesson_id UUID NOT NULL PRIMARY KEY UNIQUE,
    teacher_id UUID NOT NULL references teacher(teacher_id),
    lesson_cost int NOT NULL,
    duration int NOT NULL,
    name text NOT NULL,
    description text NOT NULL
);