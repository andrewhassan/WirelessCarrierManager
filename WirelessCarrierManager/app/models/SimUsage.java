package models;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class SimUsage extends Model {
	private static final long serialVersionUID = 932651644635206449L;

	@Id
	public Long usageId;
	
	@ManyToOne
	public SimCard simCard;
	
	@Required
	public Long timestamp;
	
	@Required
	public Long usageInBytes;
	
	@Required
	public Plan plan;
	
	public static Model.Finder<Long, SimUsage> find = new Model.Finder<Long, SimUsage>(Long.class, SimUsage.class);
}
