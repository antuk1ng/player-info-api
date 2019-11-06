package com.houseone.playerinfo.controller;

import com.houseone.playerinfo.exception.ResourceNotFoundException;
import com.houseone.playerinfo.model.Player;
import com.houseone.playerinfo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerInfoController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping(value = "/{id}")
    public Player getOne(@PathVariable String id) {
        return playerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping(value = "/player")
    public List<Player> getPlayerByName(@RequestParam String firstName, @RequestParam String lastName) {
        return playerRepository.findPlayerByName(firstName, lastName);
    }

    @GetMapping
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @PutMapping(value = "/{id}")
    public Player update(@PathVariable String id, @RequestBody Player updatedPlayer) {
        Player player = playerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        player.updateInfo(updatedPlayer);

        return playerRepository.save(player);
    }
}
