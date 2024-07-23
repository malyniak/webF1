package com.app.webf1.service;

import com.app.webf1.dto.ContractFullDto;
import com.app.webf1.mapper.contract.ContractMapper;
import com.app.webf1.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.app.webf1.Util.checkExists;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper mapper;
    public Optional<ContractFullDto> findById(Integer id) {
        var maybeContract = contractRepository.findById(id);
        checkExists(id, maybeContract);
        return maybeContract.map(mapper::toTo);
    }
    public List<ContractFullDto> findAllByYear (int lastYear) {
       return contractRepository.findAllBy(lastYear)
                .stream()
                .map(mapper::toTo)
                .collect(Collectors.toList());
    }
}
