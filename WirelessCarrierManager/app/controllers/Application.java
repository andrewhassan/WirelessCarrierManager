package controllers;

import models.*;
import com.avaje.ebean.Ebean;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {		
		return ok(index.render("Test"));
	}
	
	public static Result saveCarrier(String carrierName) {
		Carrier testCarrier = new Carrier();
		testCarrier.carrierName = carrierName;
		testCarrier.plans = null;
		Ebean.save(testCarrier);
		return ok("" + testCarrier.carrierId);
	}
	
	public static Result deleteCarrier(Long carrierId) {
		Carrier testCarrier = Ebean.find(Carrier.class, carrierId);
		
		try {
			Ebean.delete(testCarrier);
		}
		catch (Exception e) {
			return internalServerError(); 
		}
		return ok("Yay");
		
	}
	
	public static Result customTitle(String str) {
		return ok(index.render(str));
	}

}
