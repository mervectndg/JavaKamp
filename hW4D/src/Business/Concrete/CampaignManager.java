package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.CampaignService;
import Entitties.Concrete.Campaign;

public class CampaignManager implements CampaignService {

	ArrayList<Campaign> campaigns;

	public CampaignManager() {
		super();
		campaigns = new ArrayList<Campaign>();

	}

	@Override
	public Campaign get(int id) {
		Campaign campaign = campaigns.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

		if (campaign != null) {
			System.out.println("Id : " + campaign.getId());
			System.out.println("Oyun Id : " + campaign.getGameId());
			System.out.println("Kampanya Adý : " + campaign.getName());
			System.out.println("Kampanya Oraný : " + campaign.getRate());
		}
		return campaign;
	}

	@Override
	public void getAll() {

		for (Campaign campaign : campaigns) {
			System.out.println("Id : " + campaign.getId());
			System.out.println("Oyun Id : " + campaign.getGameId());
			System.out.println("Kampanya Adý : " + campaign.getName());
			System.out.println("Kampanya Oraný : " + campaign.getRate());
		}

	}

	@Override
	public void update(Campaign campaign) {
		Campaign campaignUpdate = campaigns.stream().filter(c -> c.getId() == campaign.getId()).findFirst()
				.orElse(null);
		if (campaignUpdate != null) {
			campaigns.remove(campaignUpdate);
			campaigns.add(campaign);
			System.out.println(" Kampanya baþarýyla düzenlendi");
		} else {
			System.out.println(" Kampanya sistemde bulunamadý.");
		}
	}

	@Override
	public void add(Campaign campaign) {
		campaigns.add(campaign);
		System.out.println(" Kampanya baþarýyla eklendi.");
	}

	@Override
	public void delete(int id) {
		Campaign campaignDelete = campaigns.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
		if (campaignDelete != null) {
			campaigns.remove(campaignDelete);
			System.out.println(" Kampanya baþarýyla silindi.");
		} else {
			System.out.println(" Kampanya bulunamadý. ");
		}
	}

	@Override
	public Campaign getByGameId(int gameId) {
		Campaign campaign = campaigns.stream().filter(c -> c.getGameId() == gameId).findFirst().orElse(null);
		if (campaign != null) {
			System.out.println("Id : " + campaign.getId());
			System.out.println("Oyun Id : " + campaign.getGameId());
			System.out.println("Kampanya Adý : " + campaign.getName());
			System.out.println("Kampanya Oraný : " + campaign.getRate());
		}

		return campaign;
	}

}
