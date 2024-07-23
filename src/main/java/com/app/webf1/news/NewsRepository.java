package com.app.webf1.news;

import com.app.webf1.entity.Driver;
import com.app.webf1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<F1News, Long> {
    @Query("SELECT n FROM F1News n")
    List<F1News> findAll();

    @Query("SELECT d FROM Driver d join d.car.team t where t=:team")
    List<Driver> findAllBy(Team team);
}
