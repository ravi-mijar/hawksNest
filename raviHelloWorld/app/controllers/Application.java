package controllers;

import java.sql.Connection;

import javax.sql.DataSource;

import models.Expense;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This is the main application class that controls all the flows.
 * @author Ravindra Mijar
 *
 */
public class Application extends Controller {
  
    DataSource ds = DB.getDataSource();
    Connection cnxn = DB.getConnection();
    
    //Show all the expenses from the DB in this expenseForm
    public static Result expenses() {
        return ok(views.html.index.render(Expense.all(), expenseForm));
    }
    
    //The default page, this also shows all the expenses from the DB.
    public static Result index() {
        return redirect(routes.Application.expenses());
    }
    
    /*  Function to create new expenses.
     *  This function will fetch data from the web page, and call the create method in the Expense class.
     */
    public static Result newExpense() {
        Form<Expense> filledForm = Application.expenseForm.bindFromRequest();
        
        if(filledForm.hasErrors()) {
            return badRequest(views.html.index.render(Expense.all(),Application.expenseForm));
        }
        else {
            Expense.create(filledForm.get());
            return redirect(routes.Application.expenses());
        }
    }
    
    /*
     * Method to delete the expense selected by user.
     */
    public static Result delete(Integer id) {
        Expense.delete(id);
        return redirect(routes.Application.expenses());
    }
    public static Form<Expense> expenseForm = Form.form(Expense.class); 
}
