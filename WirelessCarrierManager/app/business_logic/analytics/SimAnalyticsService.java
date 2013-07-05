package business_logic.analytics;

import view_models.*;
import java.util.*;
import org.apache.commons.lang.NotImplementedException;

import business_logic.api_data.ApiService;
import business_logic.api_data.AvailableApis;
import business_logic.api_data.TestService;

public class SimAnalyticsService {
	
	public List<SimCardSuggestion> analyzeUsage() {
		// Get all the available API services
		ApiService[] availableApis = AvailableApis.getAvailableApis();
		
		for (ApiService apiService : availableApis) {
		}
		
		throw new NotImplementedException();
	}
}
