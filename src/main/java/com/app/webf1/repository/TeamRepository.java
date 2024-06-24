package com.app.webf1.repository;

import com.app.webf1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query("SELECT t FROM Team t  WHERE t.id =:id")
    Optional<Team> findById(int id);

}
