package hW4D;

import Business.Abstract.CampaignService;
import Business.Abstract.GameService;
import Business.Abstract.UserService;
import Business.Concrete.CampaignManager;
import Business.Concrete.GameManager;
import Business.Concrete.UserManager;
import Entitties.Concrete.Campaign;
import Entitties.Concrete.Game;
import Entitties.Concrete.User;

public class Main {

	public static void main(String[] args) {

		UserService userManager = new UserManager();

		User engin = new User(1, "12345678901", "Engin", "Yenice", 1998);
		User merve= new User(2,"98765432109", "Merve", "Çetindað", 1999);
		userManager.add(engin);
		System.out.println("--------------------------------------------");
		userManager.add(merve);
		System.out.println("--------------------------------------------");

		GameService gameManager = new GameManager();
		Game maymunOyunu = new Game(1, "Maymun Oyunu", 10.55, 10);
		Game atesVeSu = new Game(2, "Ateþ Ve Su", 100, 10);
		Game atesVeSu2 = new Game(3, "Ateþ Ve Su 2", 100, 10);
		gameManager.add(maymunOyunu);
		System.out.println("--------------------------------------------");
		gameManager.add(atesVeSu);
		System.out.println("--------------------------------------------");
		gameManager.add(atesVeSu2);
		System.out.println("--------------------------------------------");

		CampaignService campaignManager = new CampaignManager();
		Campaign maymunOyunuKampanyasi = new Campaign(1, "Yaz indirimi (%50)", 50, 1);
		Campaign atesVeSuOyunuKampanyasi = new Campaign(2, "Yaz indirimi (%50)", 50, 2);
		campaignManager.add(maymunOyunuKampanyasi);
		System.out.println("--------------------------------------------");
		campaignManager.add(atesVeSuOyunuKampanyasi);
		System.out.println("--------------------------------------------");
		

		userManager.getAll();
		gameManager.getAll();
		campaignManager.getAll();
		
		
		System.out.println("--------------------------------------------");
		gameManager.sales(atesVeSu2, merve,campaignManager);
		System.out.println("--------------------------------------------");
		gameManager.sales(atesVeSu, merve, campaignManager);
		System.out.println("--------------------------------------------");
		gameManager.sales(maymunOyunu, engin,campaignManager);
		System.out.println("--------------------------------------------");
	}

}
