package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.sql.DataSource;

import play.data.validation.Constraints.Required;
import play.db.DB;
import play.db.ebean.Model;

@Entity
public class Expense extends Model {
    
    @Id
    public Integer id;
    @Required
    public String category;
    
    public String description;
    
    @Required
    public int amount;
    
    public static Finder<Integer, Expense> find = new Finder<Integer, Expense>(Integer.class, Expense.class);
    
    public static List<Expense> all() {
        DataSource ds = DB.getDataSource();
        /*try {
            System.out.println(find.fetch("select * from expenses;"));
            Connection cnxn = ds.getConnection("hawk", "Nikonl110");
            
            cnxn.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return find.all();
    }
    
    public static void create(Expense exp) {
        exp.save();
    }
    
    public static void delete(Integer id) {
        find.ref(id).delete();
    }
    
}
