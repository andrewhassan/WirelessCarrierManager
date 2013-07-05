package controllers;

import java.util.List;

import models.Carrier;
import models.Plan;
import models.PlanPool;
import models.SimCard;
import play.mvc.*;
import views.html.manage;

public class Manage extends Controller {
	public static Result index() {
		List<Carrier> carriers = Carrier.find.all();
		List<Plan> plans = Plan.find.all();
		List<PlanPool> pools = PlanPool.find.all();
		List<SimCard> sims = SimCard.find.all();
		
		return ok(manage.render(carriers, plans, pools, sims));
	}
}
