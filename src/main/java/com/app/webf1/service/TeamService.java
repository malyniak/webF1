package com.app.webf1.service;

import com.app.webf1.dto.TeamCreateDto;
import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.dto.TeamUpdateDto;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.TeamCreateMapper;
import com.app.webf1.mapper.TeamMapper;
import com.app.webf1.mapper.TeamUpdateMapper;
import com.app.webf1.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.app.webf1.Util.checkExists;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper fullMapper;
    private final TeamUpdateMapper teamUpdateMapper;
    private final TeamCreateMapper teamCreateMapper;

    @Transactional
    public Optional<TeamFullDto> findById(Integer id) {
        return Optional.ofNullable(teamRepository.findById(id)
                .map(fullMapper::toTo)
                .orElseThrow(() -> new RuntimeException("Team with" + id + " not found"))); // todo 26.06
    }

    @Transactional
    public List<TeamFullDto> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(fullMapper::toTo)
                .collect(Collectors.toList());
    }

    @Transactional
    public Team updateNumber(TeamUpdateDto teamUpdateDto, Integer id) {
        checkExists(id, teamRepository.findById(id));
        var team = teamRepository.findById(id).get();
        var teamToUpdate = teamUpdateMapper.updateFromTo(teamUpdateDto, team);
        return teamRepository.saveAndFlush(teamToUpdate);
    }

    @Transactional
    public void delete(Integer id) {
        var maybeTeam = teamRepository.findById(id);
        checkExists(id, maybeTeam);
        teamRepository.delete(maybeTeam.get());
    }
    @Transactional
    public Team create(TeamCreateDto teamCreateDto) {
        var team = teamCreateMapper.toEntity(teamCreateDto);
        return teamRepository.save(team);
    }
}
