package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Carrier extends Model {
	private static final long serialVersionUID = 1626099495840246441L;

	@Id
	public Long id;
	
	@Required
	public String name;
	
	@OneToMany(mappedBy = "carrier")
	public List<Plan> plans;
	
	public static Model.Finder<Long, Carrier> find = new Model.Finder<Long, Carrier>(Long.class, Carrier.class);
}
