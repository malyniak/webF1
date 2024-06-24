package com.app.webf1.service;

import com.app.webf1.dto.CarFullDto;
import com.app.webf1.dto.CarUpdateDto;
import com.app.webf1.entity.Car;
import com.app.webf1.entity.Team;
import com.app.webf1.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ModelMapper mapper;

    public void create(CarFullDto car) {
        carRepository.save(mapper.map(car, Car.class));
    }

    public void updateNumber(CarUpdateDto carUpdateDto) {
        var car = carRepository.findById(carUpdateDto.getId());
        car.ifPresent(c -> c.setNumber(carUpdateDto.getNumber()));
    }
    public List<CarFullDto> findAllByTeam(Team team) {
       return  carRepository.findAllBy(team).stream()
               .map(t -> mapper.map(t, CarFullDto.class))
               .collect(Collectors.toList());
    }
    public List<CarFullDto> findAllByEngine(String engine) {
        return carRepository.findAllBy(engine)
                .stream()
                .map(car -> mapper.map(car, CarFullDto.class))
                .collect(Collectors.toList());
    }
}
