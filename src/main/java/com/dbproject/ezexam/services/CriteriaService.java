package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Criteria;
import com.dbproject.ezexam.repositories.CriteriaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CriteriaService {
    private final CriteriaRepo criteriaRepo;

    public List<Criteria> getAllCriteria() {
        return criteriaRepo.findAll();
    }

    public Criteria saveCriteria(Criteria criteria) {return criteriaRepo.save(criteria);}

    public void deleteCriteria(Criteria criteria) {criteriaRepo.delete(criteria);}

    public Criteria getCriteriaById(Long criteriaId) {return criteriaRepo.findById(criteriaId)
            .orElseThrow(() -> new NoSuchElementException(
                    "Criteria not found with id: " + criteriaId)
            );}
}
