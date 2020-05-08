package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GameDao;
import com.example.demo.model.Game;

@Service
public class GameService {

	private GameDao gameDao;
	
	@Autowired
	public GameService(@Qualifier("fakeDao") GameDao gameDao) {
		this.gameDao = gameDao;
	}
	
	public int addGame(Game game) {
		return gameDao.insertGame(game);
	}
	
	public List<Game> getAllGames(){
		return gameDao.selectAllGames();
	}
	
	public Optional<Game> getGameById(UUID id){
		return gameDao.selectGameById(id);
	}
	
	public int deleteGame(UUID id) {
		return gameDao.deleteGameById(id);
	}
	
	public int updateGame(UUID id, Game newGame) {
		return gameDao.updateGameById(id, newGame);
	}
}
