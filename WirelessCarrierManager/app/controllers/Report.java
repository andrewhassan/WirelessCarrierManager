package controllers;

import models.*;
import play.mvc.*;
import views.html.*;
import java.util.*;

public class Report extends Controller {
	public static Result index() {
		List<Customer> customers = Customer.find.all();
		return ok(reportIndex.render(customers));
	}
	
	public static Result getReport(Long customer) {
		Customer c = Customer.find.byId(customer);
		
		String result = "Name: " + c.name + "\nID: " + c.id + "\nAccounts:\n";
		for (Account account : c.accounts) {
			result += "\t" + account.name + "\n";
		}
		return ok(result);
	}
}
