package project1.controllers;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.DAO.ManagerRepo;
import project1.employeeReimbursement;
import project1.models.EmployeeTable;
import project1.models.Response;

import java.util.Collection;

public class ManagerController {
    public static final Logger logger = LogManager.getLogger(employeeReimbursement.class.getName());
    public static final Logger rootLogger = LogManager.getRootLogger();
    public static void handleGetAllEmployees(Context ctx){
        ManagerRepo mr = new ManagerRepo();

        rootLogger.info("Attempting to parse EmployeeTable");

        Collection<EmployeeTable> allEmployees = mr.ParseEmployees();

        ctx.json(allEmployees);
    }
}
