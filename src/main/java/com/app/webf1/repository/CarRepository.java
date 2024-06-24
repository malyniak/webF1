package com.app.webf1.repository;

import com.app.webf1.entity.Car;
import com.app.webf1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c  WHERE c.team =:team")
    List<Car> findAllBy(Team team);

    @Query("SELECT c FROM Car c join c.team t WHERE t.engine =:engine")
    List<Car> findAllBy(String engine);

    @Modifying
    @Query("DELETE FROM Car c WHERE c.id=:id")
    int delete(long id);
}



