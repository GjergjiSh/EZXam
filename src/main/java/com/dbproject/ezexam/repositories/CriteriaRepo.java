package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepo extends JpaRepository<Criteria, Long>  {
}
