package controllers;

import models.*;
import com.avaje.ebean.Ebean;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {		
		return ok(index.render("Test"));
	}

}
