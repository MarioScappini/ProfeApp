CREATE TABLE qualification(
    qualification_id UUID NOT NULL PRIMARY KEY,
    teacher_id UUID references teacher(teacher_id),
    title text,
    institute text,
    instituteStartingDate text not null,
    instituteEndingDate text not null

);
