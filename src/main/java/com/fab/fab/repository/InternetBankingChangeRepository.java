package com.fab.fab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetBankingChangeRepository extends JpaRepository<com.fab.fab.model.InternetBankingChangeModel, Integer> {
    
}
