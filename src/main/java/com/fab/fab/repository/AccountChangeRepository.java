package com.fab.fab.repository;

import com.fab.fab.model.AccountChangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountChangeRepository extends JpaRepository<AccountChangeModel, Integer> {
    

}
