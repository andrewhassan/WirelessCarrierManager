package models;

import java.util.List;
import javax.persistence.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class SimCard extends Model {
	private static final long serialVersionUID = 8664141460726922270L;

	@Id
	@Required
	public String simNumber;
	
	public String displayName;
	
	@ManyToOne
	public PlanPool pool;
	
	@OneToMany(mappedBy = "simCard")
	public List<SimUsage> usages;
	
	public static Model.Finder<String, SimCard> find = new Model.Finder<String, SimCard>(String.class, SimCard.class);
}