package com.app.webf1.controller;

import com.app.webf1.dto.DriverCreateDto;
import com.app.webf1.dto.DriverFullDto;
import com.app.webf1.dto.DriverUpdateDto;
import com.app.webf1.entity.Driver;
import com.app.webf1.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/{id}")
    public DriverFullDto getById(@PathVariable(name = "id") Integer id) {
        return driverService.findById(id).get();
    }

    @GetMapping
    public List<DriverFullDto> getAll() {
        return driverService.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Driver update(@RequestBody DriverUpdateDto driverUpdateDto, @PathVariable Integer id) {
        return driverService.update(driverUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable Integer id) {
        driverService.delete(id);
    }

    @PutMapping("/update")
    public void create(@RequestBody DriverCreateDto driverCreateDto) {
        var driver = driverService.create(driverCreateDto);
    }
}