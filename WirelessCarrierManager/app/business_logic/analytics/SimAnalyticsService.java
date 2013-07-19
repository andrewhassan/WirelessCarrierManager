package business_logic.analytics;

import view_models.*;
import java.util.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

import models.PlanPool;
import models.SimCard;

import business_logic.api_data.ApiService;
import business_logic.api_data.AvailableApis;

public class SimAnalyticsService {
	
	private ApiService[] m_availableApis;
	
	/**
	 * Default constructor the Analytics Service
	 */
	public SimAnalyticsService() {
		m_availableApis = AvailableApis.getAvailableApis();
	}
	
	/**
	 * This is a constructor for testing. A list of mock API services may be passed in here.
	 * @param An array of ApiService objects (used for testing)
	 */
	public SimAnalyticsService(ApiService[] apiServices) {
		m_availableApis = apiServices;
	}
	
	public List<SimCardSuggestion> analyzeUsage() {
		// Get all the available API services
		List<SimCard> simCards = new ArrayList<SimCard>();
		for (ApiService apiService : m_availableApis) {
			simCards = apiService.getSimCards();
			SimCard sim = simCards.get(0);
		
		}
		
		List<PlanPool> t = PlanPool.find.all();
		
		List<SimCardSuggestion> result = new ArrayList<SimCardSuggestion>();
		SimCardSuggestion simSuggestion = new SimCardSuggestion();
		simSuggestion.simCard = SimCard.find.byId("1");
		simSuggestion.periodSavings = 1.00;
		simSuggestion.newPool = new PlanPool();
		result.add(simSuggestion);
		
		return result;
	}
}
