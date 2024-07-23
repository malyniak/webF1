package com.app.webf1.service;

import com.app.webf1.dto.DriverCreateDto;
import com.app.webf1.dto.DriverFullDto;
import com.app.webf1.dto.DriverUpdateDto;
import com.app.webf1.entity.Driver;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.driver.DriverCreateMapper;
import com.app.webf1.mapper.driver.DriverMapper;
import com.app.webf1.mapper.driver.DriverUpdateMapper;
import com.app.webf1.mapper.team.TeamCreateMapper;
import com.app.webf1.repository.CarRepository;
import com.app.webf1.repository.DriverRepository;
import com.app.webf1.repository.TeamRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.app.webf1.Util.checkExists;

@Service
@RequiredArgsConstructor
@Data
public class DriverService {
    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final TeamRepository teamRepository;
    private final DriverCreateMapper driverCreateMapper;
    private final DriverMapper mapper;
    private final TeamCreateMapper teamCreateMapper;
    private final DriverUpdateMapper driverUpdateMapper;

    @Transactional
    public Optional<DriverFullDto> findById(Integer id) {
        var maybeDriver = driverRepository.findById(id);
        checkExists(id, maybeDriver);
        return maybeDriver.map(mapper::toTo);
    }

    @Transactional
    public List<DriverFullDto> findAll() {
        return driverRepository.findAll()
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<DriverFullDto> findAllByTeam(Team team) {
        return driverRepository.findAllBy(team)
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }

    @Transactional
    public Driver update(DriverUpdateDto driverUpdateDto) {
        var id = driverUpdateDto.getId();
        checkExists(id, driverRepository.findById(id));
        var driver = driverRepository.findById(driverUpdateDto.getId()).get();
        var driverToUpdate = driverUpdateMapper.updateFromTo(driverUpdateDto, driver);
        return driverRepository.saveAndFlush(driverToUpdate);
    }

    @Transactional
    public void delete(Integer id) {
        var maybeDriver = driverRepository.findById(id);
        checkExists(id, maybeDriver);
        driverRepository.delete(maybeDriver.get());
    }

    @Transactional
    public Driver create(DriverCreateDto driverCreateDto) {
        var id = driverCreateDto.getCarCreateDto().getId();
        checkExists(id, carRepository.findById(id));
        var driver = driverCreateMapper.toEntity(driverCreateDto);
        driver.setCar(carRepository.findById(id).get());
        return driverRepository.save(driver);
    }
}



