package com.fab.fab.repository;

import java.util.List;

import com.fab.fab.model.AccountModel;
import com.fab.fab.model.BranchModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    List<AccountModel> findByBranchOrderByCreatedAt(BranchModel branchModel);

    List<AccountModel> findByBranchOrderByCreatedAtDesc(BranchModel branchModel);
    
}
