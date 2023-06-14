package com.dbproject.ezexam.dtos;

import com.dbproject.ezexam.entities.Answer;

import java.util.List;

public record UpdateExamDTO(long examId, long examSessionId, String studentMatriculationNumber, int duration,
                            double grade, List<AnswerDTO> answers) {
}