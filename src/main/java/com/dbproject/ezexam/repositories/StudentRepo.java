package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAllByNameAndLastname(String name, String lastname);

    Optional<Student> findByMatnr(String matnr);

    @Query(value = """
            select * from students
            where students.id not in (
                select exams.student_id from exams
                                join exam_sessions on exam_sessions.id = exams.exam_session_id
                                join subjects on subjects.id = exam_sessions.subject_id
                                where subject_id = ?1 and exams.grade != 0
                )
            """,
            nativeQuery = true)
    List<Student> getAllStudentsWithoutSubject(Long subjectId);
}
