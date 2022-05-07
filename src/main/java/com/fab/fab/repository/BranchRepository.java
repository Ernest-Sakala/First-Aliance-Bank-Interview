package com.fab.fab.repository;

import com.fab.fab.model.BranchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchModel, Integer> {
    
}
