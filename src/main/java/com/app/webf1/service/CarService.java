package com.app.webf1.service;

import com.app.webf1.dto.CarCreateDto;
import com.app.webf1.dto.CarFullDto;
import com.app.webf1.dto.CarUpdateDto;
import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.entity.Car;
import com.app.webf1.mapper.car.CarCreateMapper;
import com.app.webf1.mapper.car.CarMapper;
import com.app.webf1.mapper.car.CarUpdateMapper;
import com.app.webf1.mapper.team.TeamMapper;
import com.app.webf1.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.app.webf1.Util.checkExists;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper mapper;
    private final CarCreateMapper createMapper;
    private final CarUpdateMapper carUpdateMapper;
    private final TeamMapper teamMapper;

    @Transactional
    public Optional<CarFullDto> findById(Integer id) {
        var maybeCar = carRepository.findById(id);
        checkExists(id, maybeCar);
        return maybeCar.map(mapper::toTo);
    }

    @Transactional
    public List<CarFullDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }



    @Transactional
    public List<CarFullDto> findAllByTeam(TeamFullDto teamFullDto) {
        var team = teamMapper.toEntity(teamFullDto);
        return carRepository.findAllBy(team).stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CarFullDto> findAllByEngine(String engine) {
        return carRepository.findAllBy(engine)
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }
    @Transactional
    public Car create(CarCreateDto carCreateDto) {
        var car = createMapper.toEntity(carCreateDto);
        return carRepository.save(car);
    }

    @Transactional
    public Car updateNumber(CarUpdateDto carUpdateDto, Integer id) {
        var maybeCar = carRepository.findById(id);
        checkExists(id, maybeCar);
        var car = maybeCar.get();
        var carToUpdate = carUpdateMapper.updateFromTo(carUpdateDto, car);
        return carRepository.saveAndFlush(carToUpdate);
    }

    @Transactional
    public void delete(Integer id) {
        var maybeCar = carRepository.findById(id);
        checkExists(id, maybeCar);
        carRepository.delete(maybeCar.get());
    }

}
