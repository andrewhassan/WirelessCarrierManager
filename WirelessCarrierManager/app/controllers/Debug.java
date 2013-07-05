package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Carrier;
import models.Plan;
import models.PlanPool;
import models.SimCard;
import play.mvc.*;
import scala.NotImplementedError;
import views.html.*;

public class Debug extends Controller {
	
	public static Result index() {
		List<Carrier> carriers = Carrier.find.all();
		List<Plan> plans = Plan.find.all();
		List<PlanPool> pools = PlanPool.find.all();
		List<SimCard> sims = SimCard.find.all();
		
		return ok(debug.render(carriers, plans, pools, sims));
	}
	
	public static Result saveCarrier(String carrierName) {
		Carrier testCarrier = new Carrier();
		testCarrier.carrierName = carrierName;
		testCarrier.plans = null;
		Ebean.save(testCarrier);
		return redirect(routes.Manage.index());
	}
	
	public static Result updateCarrier() {
		throw new NotImplementedError();
	}
	
	public static Result deleteCarrier(Long carrierId) {
		Carrier testCarrier = Ebean.find(Carrier.class, carrierId);
		
		try {
			Ebean.delete(testCarrier);
		}
		catch (Exception e) {
			return internalServerError(); 
		}
		return redirect(routes.Manage.index());
		
	}

}
