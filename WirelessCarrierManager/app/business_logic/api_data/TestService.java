package business_logic.api_data;

import java.util.List;

import models.Plan;
import models.PlanPool;
import models.SimCard;
import models.SimUsage;
import view_models.credential.Credential;

public class TestService extends ApiService {

	@Override
	protected Credential authenticate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apiName() {
		return "Test Service";
	}

	@Override
	public List<SimCard> getSimCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimUsage> getSimUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimUsage> getSimUsage(SimCard simCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimUsage> getPlanPoolUsage(PlanPool pool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimUsage> getPlanUsage(Plan plan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reauthenticate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isStillAuthenticated() {
		// TODO Auto-generated method stub
		return null;
	}

}
