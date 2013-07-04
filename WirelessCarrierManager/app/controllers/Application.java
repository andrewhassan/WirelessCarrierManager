package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import views.html.defaultpages.error;

public class Application extends Controller {

	public static Result index() {
		//return ok(index.render("You're already connected!"));
		return ok(index.render("Test"));
	}
	
	public static Result customTitle(String str) {
		return ok(index.render(str));
	}

}
