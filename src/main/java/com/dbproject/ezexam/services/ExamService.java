package com.dbproject.ezexam.services;

import com.dbproject.ezexam.dtos.UpdateExamDTO;
import com.dbproject.ezexam.entities.Answer;
import com.dbproject.ezexam.entities.AnswerCriteria;
import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.repositories.ExamRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepo examRepo;

    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepo.findById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Exam saveExam(Exam exam) {
        return examRepo.save(exam);
    }

    public void deleteExam(Long id) {
        examRepo.deleteById(id);
    }

    public Exam updateExam(UpdateExamDTO updateExamDTO) {
        Exam storedExam = getExamById(updateExamDTO.examId()).orElseThrow(() -> new EntityNotFoundException("Exam with ID: " + updateExamDTO.examId() + " not found"));

        List<Answer> answers = getAnswers(updateExamDTO, storedExam);

        storedExam.setAnswers(answers);
        storedExam.setGrade(updateExamDTO.grade());
        storedExam.setDuration(updateExamDTO.duration());

        return examRepo.save(storedExam);
    }

    private static List<Answer> getAnswers(UpdateExamDTO updateExamDTO, Exam storedExam) {
        return updateExamDTO.answers().stream().map(answerDTO -> {
            Answer answer = new Answer(storedExam, answerDTO.question(), answerDTO.text(), answerDTO.description(), answerDTO.points(),
                    answerDTO.achievedPoints());

            List<AnswerCriteria> answerCriteria = answerDTO.answerCriterias().stream().map(criteriaDTO ->
                    new AnswerCriteria(answer, criteriaDTO.name(), criteriaDTO.description(), criteriaDTO.weight(), criteriaDTO.met())).collect(Collectors.toList());

            answer.setAnswerCriterias(answerCriteria);
            return answer;
        }).collect(Collectors.toList());
    }
}
