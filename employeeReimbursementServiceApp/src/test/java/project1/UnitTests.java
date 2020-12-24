package project1;

import io.javalin.http.Context;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import project1.DAO.DatabaseRepo;
import project1.DAO.ManagerRepo;
import project1.DAO.UserRepo;
import project1.controllers.DatabaseController;
import project1.controllers.EmployeeController;
import project1.controllers.LoginController;
import project1.controllers.ManagerController;
import project1.models.EmployeeTable;
import project1.models.ReimbursementTable;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnitTests {

    private LoginController loginController;

    private Context ctx = mock(Context.class);
    private EmployeeTable mockEmployees = mock(EmployeeTable.class);


    @Test
    public void shouldReturnEmployee(){
        UserRepo ur = new UserRepo();

        String testEmail = "ronald.martz@totallyrealemail.com";
        String testPassword = "Password123";

        String expectedFirstName = "Ronald";
        mockEmployees = ur.Authentication(testEmail,testPassword);
        Assert.assertEquals(expectedFirstName,mockEmployees.getFirst_name());
    }

    @Test
    public void shouldReturnAllEmployees(){
        ManagerRepo mr = new ManagerRepo();
        Integer expectedID = 3;
        String expectedFirstName = "Rick";
        String expectedLastName = "Sanchez";
        String expectedEmail = "pickle.rick@totallyrealemail.com";

        Integer actualID=null;
        String actualFirstName=null;
        String actualLastName=null;
        String actualEmail=null;

        Collection<EmployeeTable> employees = mr.ParseEmployees();
        for(EmployeeTable e: employees){
            actualID = e.getId();
            actualFirstName = e.getFirst_name();
            actualLastName = e.getLast_name();
            actualEmail = e.getEmail();
        }
        Assert.assertEquals(expectedID,actualID);
        Assert.assertEquals(expectedFirstName,actualFirstName);
        Assert.assertEquals(expectedLastName,actualLastName);
        Assert.assertEquals(expectedEmail,actualEmail);
    }

    @Test
    public void shouldReturnRequest(){
        DatabaseRepo dr = new DatabaseRepo();

        Integer expectedID = 7;
        String expectedResolution = "Pending";
        String expectedReason = "I'M PICKLE RICK!";

        Integer actualID = null;
        String actualResolution = null;
        String actualReason = null;

        Collection<ReimbursementTable> requests = dr.ParseTable(3);
        for(ReimbursementTable r: requests){
            actualID = r.getRequest_id();
            actualResolution = r.getResolution();
            actualReason = r.getReason();
        }

        Assert.assertEquals(expectedID,actualID);
        Assert.assertEquals(expectedResolution,actualResolution);
        Assert.assertEquals(expectedReason,actualReason);

    }

    @Test
    public void shouldParseAllRequests(){
        DatabaseRepo dr = new DatabaseRepo();

        Integer expectedID = 4;
        String expectedResolution = "Approved";
        String expectedReason = "Because I bought food for the Team.";

        Integer actualID = null;
        String actualResolution = null;
        String actualReason = null;

        Collection<ReimbursementTable> requests = dr.ParseFullTable();
        for(ReimbursementTable r: requests){
            actualID = r.getRequest_id();
            actualResolution = r.getResolution();
            actualReason = r.getReason();
        }

        Assert.assertEquals(expectedID,actualID);
        Assert.assertEquals(expectedResolution,actualResolution);
        Assert.assertEquals(expectedReason,actualReason);
    }

    @Before
    public void setup(){
        loginController = new LoginController();
    }

    /**
     * Below Tests were done using Mockito.
     */

    @Test
    public void shouldVerifyLogin(){
        when(ctx.formParam("userName")).thenReturn("ronald.martz@totallyrealemail.com");
        when(ctx.formParam("password")).thenReturn("Password123");

        LoginController.handleLogin(ctx);
        verify(ctx).redirect("/ers/home.html");

    }

    @Test
    public void shouldFailBadPassword(){
        when(ctx.formParam("userName")).thenReturn("ronald.martz@totallyrealemail.com");
        when(ctx.formParam("password")).thenReturn("Password");

        LoginController.handleLogin(ctx);
        verify(ctx).redirect("/ers");
    }

    @Test
    public void shouldFailMissingInfo(){
        when(ctx.formParam("userName")).thenReturn("ronald.martz@totallyrealemail.com");
        when(ctx.formParam("password")).thenReturn("");

        LoginController.handleLogin(ctx);
        verify(ctx).redirect("/ers");
    }

    @Test
    public void  shouldGetEmployee(){
        when(ctx.sessionAttribute("currentUser")).thenReturn("ctx.sessionAttribute(\"currentUser\",employee)");
        EmployeeController.handleGetEmployee(ctx);
        verify(ctx).json(ctx.sessionAttribute("currentUser"));
    }

    @Test
    public void shouldShowEmployee(){
        when(ctx.sessionAttribute("currentUser")).thenReturn("ctx.sessionAttribute(\"currentUser\",employee)");
        EmployeeController.handleShowEmployee(ctx);
        verify(ctx).json(ctx.sessionAttribute("currentUser"));
    }

    @Test
    public void shouldTestRequestTable(){
        ReimbursementTable testTable = new ReimbursementTable();

        Integer expectedID = 42;
        Integer actualID;

        String expectedDate = "today";
        String actualDate;

        Double expectedAmount = 75.5;
        Double actualAmount;

        String expectedReason = "Testing.";
        String actualReason;

        String expectedRes = "Done";
        String actualRes;

        String expectedResNote = "Pie.";
        String actualResNote;

        String expectedResDate = "tomorrow.";
        String actualResDate;

        testTable.setRequest_id(42);
        testTable.setRequest_date("today");
        testTable.setRequest_amount(75.5);
        testTable.setReason("Testing.");
        testTable.setResolution("Done");
        testTable.setResolution_notes("Pie.");
        testTable.setResolution_date("tomorrow.");

        actualID = testTable.getRequest_id();
        actualDate = testTable.getRequest_date();
        actualAmount = testTable.getRequest_amount();
        actualReason = testTable.getReason();
        actualRes = testTable.getResolution();
        actualResNote = testTable.getResolution_notes();
        actualResDate = testTable.getResolution_date();

        Assert.assertEquals(expectedID,actualID);
        Assert.assertEquals(expectedDate,actualDate);
        Assert.assertEquals(expectedAmount,actualAmount);
        Assert.assertEquals(expectedReason,actualReason);
        Assert.assertEquals(expectedRes,actualRes);
        Assert.assertEquals(expectedResNote,actualResNote);
        Assert.assertEquals(expectedResDate,actualResDate);

    }
}
