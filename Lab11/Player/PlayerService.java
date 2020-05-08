package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PlayerDao;
import com.example.demo.model.Player;

@Service  
public class PlayerService {

	private PlayerDao playerDao;
	
	@Autowired
	public PlayerService(@Qualifier("fakeDao") PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public int addPlayer(Player player) {
		return playerDao.insertPlayer(player);
	}
	
	public List<Player> getAllPlayers(){
		return playerDao.selectAllPlayers();
	}
	
	public Optional<Player> getPlayerById(UUID id){
		return playerDao.selectPlayerById(id);
	}
	
	public int deletePlayer(UUID id) {
		return playerDao.deletePlayerById(id);
	}
	
	public int updatePlayer(UUID id, Player newPlayer) {
		return playerDao.updatePlayerById(id, newPlayer);
	}
}