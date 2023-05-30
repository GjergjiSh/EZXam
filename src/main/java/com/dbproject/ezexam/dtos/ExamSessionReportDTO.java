package com.dbproject.ezexam.dtos;

import java.time.LocalDate;
import java.util.List;

public record ExamSessionReportDTO(String subjectName, LocalDate date, double highestGrade,
                                   double averageGrade, int fails, int passes, List<ExamDTO> exams) {
}
