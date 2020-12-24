package project1.controllers;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.DAO.DatabaseRepo;
import project1.employeeReimbursement;
import project1.models.EmployeeTable;
import project1.models.ReimbursementTable;

import java.util.Collection;

public class DatabaseController {
    public static final Logger logger = LogManager.getLogger(employeeReimbursement.class.getName());
    public static final Logger rootLogger = LogManager.getRootLogger();
    public static void handleViewReimbursements(Context ctx) {
        DatabaseRepo dr = new DatabaseRepo();

        EmployeeTable user = ctx.sessionAttribute("currentUser");
        rootLogger.info("Communicated with View Reimbursements handler with first name: " + user.getFirst_name());


        Collection<ReimbursementTable> response = dr.ParseTable(user.getId());

        ctx.json(response);
    }

    public static void handleSubmitReimbursement(Context ctx){
        if((ctx.formParam("amount").equals(""))||ctx.formParam("reason").equals("")) {
            ctx.redirect("/ers/submitReimb.html");
            rootLogger.info("Information missing from Request Form.");
        }
        else {
            EmployeeTable user = ctx.sessionAttribute("currentUser");
            DatabaseRepo dr = new DatabaseRepo();

            dr.submitRequest(ctx, user.getId());

            ctx.redirect("/ers/reimb.html");
        }
    }

    public static void handleViewAllReimbursements(Context ctx){
        DatabaseRepo dr = new DatabaseRepo();

        Collection<ReimbursementTable> response = dr.ParseFullTable();

        ctx.json(response);
    }
}
