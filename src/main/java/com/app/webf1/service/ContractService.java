package com.app.webf1.service;

import com.app.webf1.dto.ContractFullDto;
import com.app.webf1.dto.DriverFullDto;
import com.app.webf1.entity.Contract;
import com.app.webf1.repository.ContractRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ModelMapper mapper;
    public Optional<ContractFullDto> findById(Integer id) {
        return Optional.ofNullable(contractRepository.findById(id)
                .map(contract -> mapper.map(contract, ContractFullDto.class))
                .orElseThrow(() -> new RuntimeException("Contract with" + id + " not found"))); // todo 26.06
    }
    public List<ContractFullDto> findAllByYear (int lastYear) {
       return contractRepository.findAllBy(lastYear)
                .stream()
                .map(contract -> mapper.map(contract, ContractFullDto.class))
                .collect(Collectors.toList());
    }
}
