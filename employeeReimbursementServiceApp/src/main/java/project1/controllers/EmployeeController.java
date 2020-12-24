package project1.controllers;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.employeeReimbursement;
import project1.models.Response;

public class EmployeeController {
    public static final Logger logger = LogManager.getLogger(employeeReimbursement.class.getName());
    public static final Logger rootLogger = LogManager.getRootLogger();
    public static void handleGetEmployee(Context ctx){
        Response response = new Response();

        response.setBody(ctx.sessionAttribute("currentUser"));
        ctx.json(response);
    }

    public static void handleShowEmployee(Context ctx){
        rootLogger.info("Reached the ShowEmployee handler.");
        Response response = new Response();
        response.setBody(ctx.sessionAttribute("currentUser"));
        ctx.json(response);
    }
}
