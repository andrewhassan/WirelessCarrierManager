package business_logic.simcard;

import java.util.*;
import models.*;

/**
 * SIM Card Service
 * @author Andrew Hassan
 * The SIM Card Service class provides methods for interacting with the SIM Cards
 */
public class SimCardService {
	/**
	 * This method goes through the available APIs list, gets the SIM cards associated with each carrier, then combines
	 * them all into one list. It then makes sure that each SIM card is stored in the database. If there are new SIM cards
	 * that didn't exist before, then it will create a new plan pool for that SIM card that's set to "unlimited" data.
	 * @return A list of all the SIM cards for each carrier.
	 */
	public List<SimCard> getSimCards() {
		return null;
	}
}
