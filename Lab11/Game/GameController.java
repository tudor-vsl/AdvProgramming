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

import com.example.demo.model.Game;
import com.example.demo.service.GameService;

@RequestMapping("api/game")
@RestController
public class GameController {

		private final GameService gameService;
		
		@Autowired
		public GameController(GameService gameService) {
			this.gameService = gameService;
		}
		
		@PostMapping
		public void addGame(@RequestBody Game game) {
			gameService.addGame(game);
		}
		
		@GetMapping
		public List<Game> getAllGames(){
			return gameService.getAllGames();
		}
		
		@GetMapping(path = "{id}")
		public Game getGameById(@PathVariable("id") UUID id) {
			return gameService.getGameById(id)
					.orElse(null);
		}
		
		@DeleteMapping ( path = "{id}")
		public void deleteGameById(@PathVariable("id") UUID id) {
			gameService.deleteGame(id);
		}
		
		@PutMapping (path = "{id}")
		public void updateGame(@PathVariable("id") UUID id, @RequestBody Game playerToUpdate) {
			gameService.updateGame(id, playerToUpdate);
		}
		
		
		
	}

