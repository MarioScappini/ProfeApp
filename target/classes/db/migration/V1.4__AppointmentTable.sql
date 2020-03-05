CREATE TABLE appointment(
    teacher_id UUID references teacher(teacher_id),
    student_id UUID references student(student_id),
    lesson_id UUID references lesson(lesson_id),
    appointment_date DATE NOT NULL DEFAULT CURRENT_DATE,
    student_rating int,
    intial_time TIME,
    final_time TIME,
    status varchar(9) NOT NULL
        CHECK(
            status = 'completed' OR
            status = 'COMPLETED' OR
            status = 'scheduled' OR
            status = 'SCHEDULED'
        )
);