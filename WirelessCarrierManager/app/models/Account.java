package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Account extends Model {
	private static final long serialVersionUID = -4685062962120755618L;

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public String billingAddress;
	
	@ManyToOne
	public Customer customer;
	
	@OneToMany(mappedBy="account")
	public List<SimCard> sims;
	
	public static Model.Finder<Long, Account> find = new Model.Finder<Long, Account>(Long.class, Account.class);
}
