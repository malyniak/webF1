package com.app.webf1.controller;

import com.app.webf1.dto.CarCreateDto;
import com.app.webf1.dto.CarFullDto;
import com.app.webf1.dto.CarUpdateDto;
import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.entity.Car;
import com.app.webf1.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;


    @GetMapping("/{id}")
    public CarFullDto getById(@PathVariable(name = "id") Integer id) {
        return carService.findById(id).get();
    }

    @GetMapping
    public List<CarFullDto> getAll() {
        return carService.findAll();
    }

    @GetMapping("/team")
    public List<CarFullDto> getAllByTeam(@RequestBody TeamFullDto teamFullDto) {
        return carService.findAllByTeam(teamFullDto);
    }

    @GetMapping("/engine")
    public List<CarFullDto> getAllByEngine(@RequestParam String engine) {
        return carService.findAllByEngine(engine);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Car updateNumber(@RequestBody CarUpdateDto carUpdateDto, @PathVariable Integer id) {
        return carService.updateNumber(carUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        carService.delete(id);
    }

    @PutMapping
    public void create(@RequestBody CarCreateDto driverCreateDto) {
        carService.create(driverCreateDto);
    }
}
