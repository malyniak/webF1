package com.app.webf1.service;

import com.app.webf1.dto.DriverFullDto;
import com.app.webf1.entity.Team;
import com.app.webf1.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;
    private final ModelMapper mapper;

    public Optional<DriverFullDto> findById(Integer id) {
        return Optional.ofNullable(driverRepository.findById(id)
                .map(driver -> mapper.map(driver, DriverFullDto.class))
                .orElseThrow(() -> new RuntimeException("Driver with" + id + " not found"))); // todo 26.06
    }

    public List<DriverFullDto> findAll() {
        return driverRepository.findAll()
                .stream()
                .map(driver -> mapper.map(driver, DriverFullDto.class))
                .collect(Collectors.toList());
    }

    public List<DriverFullDto> findAllByTeam(Team team) {
        return driverRepository.findAllBy(team)
                .stream()
                .map(driver -> mapper.map(driver, DriverFullDto.class))
                .collect(Collectors.toList());
    }
}
