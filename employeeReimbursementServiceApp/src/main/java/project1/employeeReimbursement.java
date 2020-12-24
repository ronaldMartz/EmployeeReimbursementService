package project1;

import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.controllers.DatabaseController;
import project1.controllers.EmployeeController;
import project1.controllers.LoginController;
import project1.controllers.ManagerController;

public class employeeReimbursement {
    public static final Logger logger = LogManager.getLogger(employeeReimbursement.class.getName());
    public static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Javalin app = Javalin
                .create(config -> {
                    config.addStaticFiles("/public");
                    config.contextPath = "/ers";
                })
                .start(8080);

        app.post("/login", LoginController::handleLogin);
        app.get("/home", EmployeeController::handleGetEmployee);
        app.get("/info", EmployeeController::handleShowEmployee);
        app.get("/reimb", DatabaseController::handleViewReimbursements);
        app.post("/submitReimb", DatabaseController::handleSubmitReimbursement);
        app.get("/allEmployees", ManagerController::handleGetAllEmployees);
        app.get("/allReimb", DatabaseController::handleViewAllReimbursements);

    }
}
