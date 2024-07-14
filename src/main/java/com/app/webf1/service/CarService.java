package com.app.webf1.service;

import com.app.webf1.dto.CarFullDto;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.CarMapper;
import com.app.webf1.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper mapper;

//    public void create(CarFullDto car) {
//        carRepository.save(mapper.toEntity(car));
//    }
//
//    public void updateNumber(CarUpdateDto carUpdateDto) {
//        var car = carRepository.findById(carUpdateDto.getId());
//        car.ifPresent(c -> c.setNumber(carUpdateDto.getNumber()));
//    }

    public List<CarFullDto> findAllByTeam(Team team) {
        return carRepository.findAllBy(team).stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }

    public List<CarFullDto> findAllByEngine(String engine) {
        return carRepository.findAllBy(engine)
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }
}
