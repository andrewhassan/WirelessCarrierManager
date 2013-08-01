package models;

import java.util.List;
import javax.persistence.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Customer extends Model {
	private static final long serialVersionUID = -2763679369161211275L;

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public String billingAddress;
	
	@OneToMany(mappedBy="customer")
	public List<Account> accounts;
	
	public static Model.Finder<Long, Customer> find = new Model.Finder<Long, Customer>(Long.class, Customer.class);
}
