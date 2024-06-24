package com.app.webf1.repository;

import com.app.webf1.entity.Driver;
import com.app.webf1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("SELECT d FROM Driver d  WHERE d.id =:id")
    Optional<Driver> findById(int id);

    @Query("SELECT d FROM Driver d")
    List<Driver> findAll();

    @Query("SELECT d FROM Driver d join d.car.team t where t=:team")
    List<Driver> findAllBy(Team team);

}
