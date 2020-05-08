
package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Game;

@Repository("fakeDao")

public class FakeGameDataAccessService implements GameDao{

	private static List<Game> DB = new ArrayList<>();
	
	@Override
	public int insertGame(UUID id, Game game) {
		DB.add(new Game(id, game.getWinner(), game.getDate(), game.getContent()));
		return 1; 
}

	@Override
	public List<Game> selectAllGames() {
		return DB;
	}

	@Override
	public Optional<Game> selectGameById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
				.filter(game -> game.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deleteGameById(UUID id) {
		Optional<Game> gameMaybe = selectGameById(id);
		if(gameMaybe.isEmpty()) {
			return 0;
		}
		 DB.remove(gameMaybe.get());
		 return 1;
	}

	@Override
	public int updateGameById(UUID id, Game update) {
		return selectGameById(id)
				.map(game -> {
					int indexOfGameToUpdate = DB.indexOf(game);
					if( indexOfGameToUpdate >= 0) {
						DB.set(indexOfGameToUpdate, new Game(id, update.getWinner(), update.getDate(), update.getContent()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}
}
