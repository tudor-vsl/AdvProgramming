package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;

@RequestMapping("api/player")
@RestController
public class PlayerController {


	private final PlayerService playerService;
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@PostMapping
	public void addPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
	}
	
	@GetMapping
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@GetMapping(path = "{id}")
	public Player getPlayerById(@PathVariable("id") UUID id) {
		return playerService.getPlayerById(id)
				.orElse(null);
	}
	
	@DeleteMapping ( path = "{id}")
	public void deletePlayerById(@PathVariable("id") UUID id) {
		playerService.deletePlayer(id);
	}
	
	@PutMapping (path = "{id}")
	public void updatePlayer(@PathVariable("id") UUID id, @RequestBody Player playerToUpdate) {
		playerService.updatePlayer(id, playerToUpdate);
	}
	
	
	
}
