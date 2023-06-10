package com.dbproject.ezexam.dtos;

import java.util.List;

public record AnswerDTO(long examId, String question, String text, double points, double achievedPoints,
                        String description, List<CriteriaDTO> answerCriterias) {
}
