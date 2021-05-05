package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.CampaignService;
import Business.Abstract.GameService;
import Entitties.Concrete.Campaign;
import Entitties.Concrete.Game;
import Entitties.Concrete.User;

public class GameManager implements GameService {

	ArrayList<Game> games;

	public GameManager() {
		super();
		games = new ArrayList<Game>();
	}

	@Override
	public Game get(int id) {
		Game game=games.stream().filter(c->c.getId()==id).findFirst().orElse(null);
		System.out.println("---------- Tek bir oyun getirme iþlemi baþlangýcý-----------");
		if(game!=null) {
		System.out.println("Id : "+ game.getId());
		System.out.println("Oyun adý : "+ game.getName());
		System.out.println("Fiyatý : "+ game.getPrice());
		System.out.println("Stok : "+ game.getStock());
		}else {
			System.out.println(	" Oyun bulunamadý ");
		}
		System.out.println("---------- Tek bir oyun getirme iþlemi son -----------");
		return game;
	}

	@Override
	public void getAll() {

		for (Game game : games) {
			System.out.println("---------- Tüm oyunlarý getirme iþlemi baþlangýcý-----------");
			System.out.println("Id : "+ game.getId());
			System.out.println("Oyun adý : "+ game.getName());
			System.out.println("Fiyatý : "+ game.getPrice());
			System.out.println("Stok : "+ game.getStock());
			System.out.println("---------------------------------------------");
		}
		System.out.println("---------- Tüm oyunlarý getirme iþlemi son -----------");

	}

	@Override
	public void update(Game game) {
		Game gameUpdate = games.stream().filter(c -> c.getId() == game.getId()).findFirst().orElse(null);
		if(gameUpdate!=null) {
		games.remove(gameUpdate);
		games.add(game);
		System.out.println(" Oyun baþarýyla güncellendi.");
		}else {
			System.out.println(" Oyun bulunamadý. ");
		}
		
	}

	@Override
	public void add(Game game) {
		games.add(game);
		System.out.println(" Oyun baþarýyla eklendi.");

	}

	@Override
	public void delete(int id) {
		Game gameDelete=games.stream().filter(c->c.getId()==id).findFirst().orElse(null);
		if(gameDelete!=null) {
			games.remove(gameDelete);
			System.out.println(" Oyun baþarýyla silindi.");
		}else {
			System.out.println(" Oyun bulunamadý.");
		}
		

	}

	@Override
	public void sales(Game selectedGame, User user, CampaignService campaignManager) {
		
		Campaign campaign=campaignManager.getByGameId(selectedGame.getId());
		
		double finalPrice = selectedGame.getPrice();		
		if(campaign !=null) {
			int rate=100- campaign.getRate();
			finalPrice=(rate* selectedGame.getPrice())/100;
			System.out.println("Oyun " + campaign.getName() + " indirimine girdi. ");
			System.out.println("Fiyatý " + selectedGame.getPrice() + " yerine " + finalPrice + " olarak güncellendi");
			
		}
		
		System.out.println( selectedGame.getName() +   " Ýsimli oyun " + user.getFirstName() + " " + user.getLastName() + " kiþisi tarafýndan " + finalPrice + " liraya satýn alýndý");
		
	}

}
