package com.fab.fab.repository;

import com.fab.fab.model.VisaChangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaChangeRepository extends JpaRepository<VisaChangeModel, Integer> {
    
}
