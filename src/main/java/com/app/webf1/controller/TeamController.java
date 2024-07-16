package com.app.webf1.controller;

import com.app.webf1.dto.TeamCreateDto;
import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.dto.TeamUpdateDto;
import com.app.webf1.entity.Team;
import com.app.webf1.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/{id}")
    public TeamFullDto getById(@PathVariable(name = "id") Integer id) {
        return teamService.findById(id).get();
    }

    @GetMapping
    public List<TeamFullDto> getAll() {
        return teamService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Team update(@RequestBody TeamUpdateDto teamUpdateDto, @PathVariable Integer id) {
        return teamService.updateNumber(teamUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        teamService.delete(id);
    }

    @PutMapping
    public void create(@RequestBody TeamCreateDto teamCreateDto) {
        teamService.create(teamCreateDto);
    }
}
