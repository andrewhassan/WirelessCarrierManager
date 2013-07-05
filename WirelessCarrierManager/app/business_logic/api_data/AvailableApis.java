package business_logic.api_data;


public class AvailableApis {
	private static ApiService[] availableApis = {new TestService()};
	
	public static ApiService[] getAvailableApis() {
		return availableApis;
	}
}
