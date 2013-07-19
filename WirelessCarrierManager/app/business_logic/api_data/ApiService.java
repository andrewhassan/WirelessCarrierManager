package business_logic.api_data;

import models.*;
import java.util.*;
import view_models.credential.*;

/**
 * ApiService class
 * @author Andrew Hassan
 * This class is to be inherited by each carrier API the user wishes to connect to.
 * It provides abstract methods that outline the common behaviour between all API services.
 */
public abstract class ApiService {
	/**
	 * Private Credential variable: stores the credentials for that instance of the service
	 */
	@SuppressWarnings("unused")
	private Credential m_credential = authenticate();

	/**
	 * This method is run on class instantiation and the result is stored in private variable "m_credential".
	 * This value will be used to authenticate API requests.
	 * @return Credential for internal class use.
	 */
	protected abstract Credential authenticate();
	public abstract void reauthenticate();
	public abstract Boolean isStillAuthenticated();
	
	public abstract String apiName();
	
	public abstract List<SimCard> getSimCards();
	public abstract List<SimUsage> getSimUsage();
	public abstract List<SimUsage> getSimUsage(SimCard simCard);
	public abstract List<SimUsage> getPlanPoolUsage(PlanPool pool);
	public abstract List<SimUsage> getPlanUsage(Plan plan);

}