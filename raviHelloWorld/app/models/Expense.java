package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * This is the model class that represents the Expenses one makes.
 * 
 * @author Ravindra Mijar.
 *
 */
@Entity
public class Expense extends Model {
    
    @Id
    public Integer id;
    @Required
    //Category of expenditure for eg: clothes, food, bills etc.
    public String category;
    
    //detailed description of the expenses.
    public String description;
    
    @Required
    //amount spent.
    public int amount;
    
    public static Finder<Integer, Expense> find = new Finder<Integer, Expense>(Integer.class, Expense.class);
    
    //This method just lists all the expenses found in the DB.
    public static List<Expense> all() {
        return find.all();
    }
    
    //This method saves the expense object passed in to the DB.
    public static void create(Expense exp) {
        exp.save();
    }
    
    //This method deletes the expense object based on the id passed.
    public static void delete(Integer id) {
        find.ref(id).delete();
    }
    
}
