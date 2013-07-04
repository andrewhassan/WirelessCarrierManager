package models;

import java.util.List;
import javax.persistence.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Plan extends Model {
	private static final long serialVersionUID = 3449260996848874860L;
	
	@Id
	public Long planId;
	
	@Required
	public Long billingPeriodInDays;
	
	@Required
	public Double flatRatePerBillingPeriod;
	
	@Required
	public Double dataRatePerByte;
	
	@Required
	public Long numBytesUntilOverage;
	
	@Required
	public Double overageDataRatePerByte;
	
	@OneToMany
	public List<PlanPool> pools;
	
	@ManyToOne
	public Carrier carrier;
	
	public static Model.Finder<Long, Plan> find = new Model.Finder<Long, Plan>(Long.class, Plan.class);
	
}
