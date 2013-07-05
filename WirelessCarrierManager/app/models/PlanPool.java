package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class PlanPool extends Model {
	private static final long serialVersionUID = 4083095490040410160L;

	@Id
	public Long poolId;
	
	public String displayName;
	
	@ManyToOne
	public Plan plan;
	
	@OneToMany
	public List<SimCard> simCards;
	
	@Required
	public Boolean isUnlimited;
	
	@Required
	public Long maxBytes;
	
	public static Model.Finder<Long, PlanPool> find = new Model.Finder<Long, PlanPool>(Long.class, PlanPool.class);
}
