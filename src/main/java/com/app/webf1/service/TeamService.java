package com.app.webf1.service;

import com.app.webf1.dto.CarUpdateDto;
import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    public Optional<TeamFullDto> findById(Integer id) {
        return Optional.ofNullable(teamRepository.findById(id)
                .map(team -> mapper.map(team, TeamFullDto.class))
                .orElseThrow(() -> new RuntimeException("Team with" + id + " not found"))); // todo 26.06
    }
    public void update(TeamFullDto teamFullDto) {
        var team = teamRepository.findById(teamFullDto.getId());
        team.ifPresent(c -> {
            c.setName(teamFullDto.getName());
            c.setBoss(teamFullDto.getBoss());
            c.setEngine(teamFullDto.getEngine());
        });
    }

}
