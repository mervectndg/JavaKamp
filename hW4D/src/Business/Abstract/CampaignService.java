package Business.Abstract;

import Entitties.Concrete.Campaign;

public interface CampaignService {
	Campaign get(int id);
	Campaign getByGameId(int gameId);
	void getAll();
	void update(Campaign campaign);
	void add(Campaign campaign);
	void delete(int id);
}
