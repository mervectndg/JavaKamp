package Business.Abstract;


import Entitties.Concrete.Game;
import Entitties.Concrete.User;


public interface GameService {

	Game get(int id);
	void getAll();
	void update(Game game);
	void add(Game game);
	void delete(int idt);
	void sales(Game selectedGame,User user,CampaignService campaignManager);
	
}
