package business_logic.analytics;

import view_models.*;
import java.util.*;

import business_logic.api_data.ApiService;
import business_logic.api_data.AvailableApis;

public class SimAnalyticsService {
	
	public List<SimCardSuggestion> analyzeUsage() throws Exception {
		// Get all the available API services
		ApiService[] availableApis = AvailableApis.getAvailableApis();
		
		for (ApiService apiService : availableApis) {
		}
		
		throw new Exception();
	}
}
