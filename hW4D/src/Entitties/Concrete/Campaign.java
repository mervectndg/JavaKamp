package Entitties.Concrete;

import Entitties.Abstract.Entity;

public class Campaign implements Entity{
	
	private int id;
	private String name;
	private int rate;
	private int gameId;
	
	
	
	
	
	public Campaign(int id, String name, int rate, int gameId) {
		super();
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.gameId = gameId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	
	
	

}
