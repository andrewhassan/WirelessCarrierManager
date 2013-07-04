package models;

import java.util.List;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class SimCard extends Model {
	private static final long serialVersionUID = 8664141460726922270L;

	@Id
	public String simId;
	
	@Required
	public String displayName;
	
	@ManyToOne
	public PlanPool pool;
	
	@OneToMany
	public List<SimUsage> usages;
	
	public static Model.Finder<Long, SimCard> find = new Model.Finder<Long, SimCard>(Long.class, SimCard.class);
}