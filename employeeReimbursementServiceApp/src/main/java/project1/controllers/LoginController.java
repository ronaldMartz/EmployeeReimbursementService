package project1.controllers;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.DAO.UserRepo;
import project1.employeeReimbursement;
import project1.models.EmployeeTable;
import project1.util.ConnectionDao;

public class LoginController extends ConnectionDao {
    public static final Logger logger = LogManager.getLogger(employeeReimbursement.class.getName());
    public static final Logger rootLogger = LogManager.getRootLogger();
    public static void handleLogin(Context ctx){
        if((ctx.formParam("userName").equals(""))||(ctx.formParam("password").equals(""))) {
            rootLogger.info("Missing information in Login.");
            ctx.redirect("/ers");
        }
        else{
            String user = ctx.formParam("userName");
            String pass = ctx.formParam("password");
            UserRepo ur = new UserRepo();

            EmployeeTable employee = ur.Authentication(user, pass);

            if (employee != null) {
                rootLogger.info("Authentication successful");
                ctx.sessionAttribute("currentUser", employee);
                ctx.redirect("/ers/home.html");
            } else {
                rootLogger.info("Invalid email or password.");
                ctx.redirect("/ers");
            }
        }
    }
}
