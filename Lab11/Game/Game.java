package com.example.demo.model;

import java.util.UUID;

public class Game {

	private UUID id;
	private String winner;
	private String date;
	private String content;
	
	public Game(UUID id, String winner, String date, String content) {
		this.id = id;
		this.winner = winner;
		this.date = date;
		this.content = content;
	}

	public UUID getId() {
		return id;
	}


	public String getWinner() {
		return winner;
	}


	public String getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	
}
