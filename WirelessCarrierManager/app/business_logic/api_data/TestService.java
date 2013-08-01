package business_logic.api_data;

import java.util.ArrayList;
import java.util.List;

import models.Carrier;
import models.Plan;
import models.PlanPool;
import models.SimCard;
import models.SimUsage;
import view_models.credential.Credential;

/**
 * TestService service
 * @author Andrew Hassan
 * This service is created for emulating an API service for testing.
 */
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
		List<SimCard> simCards = new ArrayList<SimCard>();
		
		// Set up carrier
		Carrier carrier = new Carrier();
		carrier.id = 1l;
		carrier.name = "Test Carrier";
		
		// Set up plan
		Plan plan = new Plan();
		plan.carrier = carrier;
		plan.billingPeriodInDays = 30l;
		plan.dataRatePerByte = 1.00;
		plan.flatRatePerBillingPeriod = 5.00;
		plan.numBytesUntilOverage = 1000l;
		plan.overageDataRatePerByte = 2.00;
		
		// Set up pool
		PlanPool pool = new PlanPool();
		pool.displayName = "Test Pool";
		pool.isDefaultPool = false;
		pool.isUnlimited = false;
		pool.maxBytes = 5000l;
		pool.maxCards = 5l;
		pool.id = 1l;
		pool.plan = plan;
		
		// Set up Sim Card
		SimCard simCard = new SimCard();
		simCard.simNumber = "abcd1";
		simCard.displayName = "Sim Card 1";
		simCard.pool = pool;
		
		carrier.plans = add(new ArrayList<Plan>(), plan);
		plan.pools = add(new ArrayList<PlanPool>(), pool);
		pool.simCards = add(new ArrayList<SimCard>(), simCard);
		
		simCards.add(simCard);
		
		return simCards;
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
	
	/**
	 * Private method to add an element to a list immuatbly (doesn't change the original list)
	 * @param list
	 * @param newElement
	 * @return
	 */
	private static <T> List<T> add (List<T> list, T newElement) {
		List<T> result = new ArrayList<T>(list);
		result.add(newElement);
		return result;
	}

}
