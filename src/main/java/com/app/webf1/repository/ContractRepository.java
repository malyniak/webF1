package com.app.webf1.repository;

import com.app.webf1.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query("SELECT c FROM Contract c  WHERE c.id =:id")
    Optional<Contract> findById(int id);

    @Query("SELECT c FROM Contract c where c.lastYear = YEAR(current_date)")
    List<Contract> findAllBy(int lastYear);
}
