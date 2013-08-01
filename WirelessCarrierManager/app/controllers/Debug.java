package controllers;

import java.util.List;

import business_logic.analytics.SimAnalyticsService;

import com.avaje.ebean.Ebean;

import models.Carrier;
import models.Customer;
import models.Plan;
import models.PlanPool;
import models.SimCard;
import play.mvc.*;
import scala.NotImplementedError;
import view_models.SimCardSuggestion;
import views.html.*;

public class Debug extends Controller {
	
	public static Result index() {
		List<Carrier> carriers = Carrier.find.all();
		List<Plan> plans = Plan.find.all();
		List<PlanPool> pools = PlanPool.find.all();
		List<SimCard> sims = SimCard.find.all();
		
		return ok(debug.render(carriers, plans, pools, sims));
	}
	
	// SAVE METHODS
	public static Result saveCarrier(String carrierName) {
		Carrier testCarrier = new Carrier();
		testCarrier.name = carrierName;
		testCarrier.plans = null;
		Ebean.save(testCarrier);
		return ok(testCarrier.id.toString());
	}
	
	public static Result savePlan (Long carrierId) {
		Carrier carrier = Carrier.find.byId(carrierId);
		if (carrier == null) {
			return badRequest("Carrier ID doesn't exist.");
		}
		
		Plan newPlan = new Plan();
		newPlan.carrier = carrier;
		newPlan.billingPeriodInDays = 30l;
		newPlan.flatRatePerBillingPeriod = 1.00;
		newPlan.dataRatePerByte = 0.05;
		newPlan.numBytesUntilOverage = 1024l;
		newPlan.overageDataRatePerByte = 1.00;
		
		newPlan.save();
		
		return ok(newPlan.id.toString());
		
	}
	
	public static Result savePool (String name, Long planId) {
		Plan plan = Plan.find.byId(planId);
		if (plan == null) {
			return badRequest("Plan ID doesn't exist.");
		}
		
		PlanPool pool = new PlanPool();
		pool.displayName = name;
		pool.plan = plan;
		pool.isDefaultPool = false;
		pool.isUnlimited = false;
		pool.maxBytes = 123456l;
		pool.maxCards = 3l;
		
		pool.save();
		
		return ok(pool.id.toString());
		
	}
	
	public static Result saveSim (String simNumber, Long poolId, String name, Long accountId) {
		PlanPool pool = PlanPool.find.byId(poolId);
		if (pool == null) {
			return badRequest("Pool ID doesn't exist.");
		}
		
		models.Account account = models.Account.find.byId(accountId);
		if (account == null) {
			return badRequest("Account ID doesn't exist.");
		}
		
		SimCard sim = new SimCard();
		sim.simNumber = simNumber;
		sim.displayName = name;
		sim.pool = pool;
		sim.account = account;
		
		sim.save();
		
		return ok(sim.simNumber);
	}
	
	public static Result saveCustomer (String customerName) {
		Customer customer = new Customer();
		customer.name = customerName;
		
		customer.save();
		
		return ok(customer.id.toString());
	}
	
	public static Result saveAccount (String accountName, Long customerId) {
		Customer customer = Customer.find.byId(customerId);
		if (customer == null) {
			return badRequest("Customer ID couldn't be found.");
		}
		
		models.Account account = new models.Account();
		
		account.customer = customer;
		account.name = accountName;
		account.save();
		
		return ok (account.id.toString());
	}

	
	
	// DELETE METHODS
	public static Result deleteCarrier(Long carrierId) {
		Carrier testCarrier = Ebean.find(Carrier.class, carrierId);
		
		try {
			Ebean.delete(testCarrier);
		}
		catch (Exception e) {
			return internalServerError(); 
		}
		return ok("Deleted carrier " + carrierId);
		
	}
	
	public static Result deleteSim(String simNumber) {
		SimCard sim = SimCard.find.byId(simNumber);
		try {
			sim.delete();
		}
		catch (Exception e) {
			return badRequest("Couldn't delete SIM card.");
		}
		return ok("Deleted SIM card " + simNumber);
	}
	
	
	// FIND METHODS
	public static Result findCarrier (Long carrierId) {
		Carrier carrier = Carrier.find.byId(carrierId);
		if (carrier == null) {
			return badRequest("Carrier ID doesn't exist.");
		}
		
		StringBuilder result = new StringBuilder();
		result.append("Carrier name: " + carrier.name + "\n");
		result.append("Plans: \n");
		for (Plan plan : carrier.plans) {
			result.append("\t" + plan.id + "\n");
		}
		
		return ok (result.toString());
		
	}
	
	public static Result findPlan (Long planId) {
		Plan plan = Plan.find.byId(planId);
		if (plan == null) {
			return badRequest("Plan ID doesn't exist.");
		}
		
		StringBuilder result = new StringBuilder();
		result.append("Plan ID: " + plan.id + "\n");
		result.append("Plan Pools: \n");
		for (PlanPool pool : plan.pools ) {
			result.append("\t" + pool.displayName + "\n");
		}
		result.append("Carrier: " + plan.carrier.name);
		
		return ok (result.toString());
		
	}
	
	public static Result findPool (Long poolId) {
		PlanPool pool = PlanPool.find.byId(poolId);
		if (pool == null) {
			return badRequest("Pool ID doesn't exist");
		}
		
		StringBuilder result = new StringBuilder();
		result.append("Pool ID:" + pool.id + "\n");
		result.append("Name: " + pool.displayName + "\n");
		result.append("Plan ID: " + pool.plan.id + "\n");
		result.append("Sim Cards: \n");
		for (SimCard sim : pool.simCards) {
			result.append("\t" + sim.displayName + "\n");
		}
		return ok(result.toString());
	}
	
	
	// ANALYZE METHOD
	public static Result analyze() {
		SimAnalyticsService service = new SimAnalyticsService();
		List<SimCardSuggestion> result = service.analyzeUsage();
		if (result.get(0).simCard == null) {
			return ok("Sim card is null");
		}
		else if (result.get(0).simCard.pool == null) {
			return ok("The pool is null");
		}
		else {
			return ok(result.get(0).simCard.pool.displayName);
		}
	}

}
