package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Criteria;
import com.dbproject.ezexam.repositories.CriteriaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaService {
    private final CriteriaRepo criteriaRepo;

    public List<Criteria> getAllCriteria() {
        return criteriaRepo.findAll();
    }
}
