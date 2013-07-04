package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;
import play.db.ebean.Model;

@Entity
public class Entry extends Model {
	@Id
	public Long id;
	
	@Constraints.Required
	public String name;
	
	public static Model.Finder<Long, Entry> find = new Model.Finder<Long, Entry>(Long.class, Entry.class);
}