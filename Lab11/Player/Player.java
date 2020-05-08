package com.example.demo.model;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	private UUID id;
	private String name;
	
	public Player(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
