package controllers;

import java.sql.Connection;

import javax.sql.DataSource;

import models.Expense;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
    DataSource ds = DB.getDataSource();
    Connection cnxn = DB.getConnection();
    
    public static Result expenses() {
        return ok(views.html.index.render(Expense.all(), expenseForm));
    }
    
    
    public static Result index() {
        return redirect(routes.Application.expenses());
    }
    
    
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
    
    public static Result delete(Integer id) {
        Expense.delete(id);
        return redirect(routes.Application.expenses());
    }
    public static Form<Expense> expenseForm = Form.form(Expense.class); 
}
