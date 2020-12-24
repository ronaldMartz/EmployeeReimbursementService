# EmployeeReimbursementService
## Project Description

A web based service for Employees to request a reimbursement for Manager approval. Managers can register Employees to the service and approve or deny the reimbursement requests.

## Technologies Used

Java - 1.8
Javalin - 3.3.0
Hibernate - 4.3.11.Final
PostgreSQL - 42.2.18
log4j - 2.13.3
Mockito - 3.1.0
Junit - 4.12
Jackson - 2.11.3
Fetch
HTML/CSS/Javascript

## Features

List of features ready and TODOs for future development
-An Employee can login
-An Employee can view the Employee Homepage
-An Employee can logout
-An Employee can submit a reimbursement request
-An Employee can view their pending reimbursement requests
-An Employee can view their resolved reimbursement requests
-An Employee can view their information
-A Manager can login
-A Manager can view the Manager Homepage
-A Manager can logout
-A Manager can view all pending requests from all employees
-A Manager can view all resolved requests from all employees and see which manager resolved it
-A Manager can view all Employees

To-do list:
-An Employee can update their information
-An Employee receives an email when one of their reimbursement requests is resolved (optional)
-A Manager can approve/deny pending reimbursement requests
-A Manager can view reimbursement requests from a single Employee
-A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)
-An Employee can reset their password (Optional - tied with above functional requirement)

## Getting Started
   
git clone https://github.com/ronaldMartz/EmployeeReimbursementService.git

## Usage

When the program starts you should see https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/Login.png which requests the user's email and password.
When user logs in as an Employee they would see https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/HomePage.png
Managers would see the same page with additional information for reviewing reimbursements and all employees.
Clicking the "Home" link returns the user back to this main page.
Clicking the "Information" link takes the user to an Employee Information page: https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/EmployeeInfo.png
Clicking the "Reimbursements" link takes the user to the submission form to submit a new request: https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/SubmitRequest.png
Clicking the "Logout" link takes the user back to the index, login page.

As a Manager you would then see "Review," "Employees," and "Register."
The "Review" link would take you to https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/RequestHistory.png
- This would be where I would have implemented the apply or deny options for the Manager to select.
The "Employees" link would take you to https://github.com/ronaldMartz/EmployeeReimbursementService/blob/main/Images/AllEmployee.png
- This is where you would see a list of all employees, be able to update information, and remove employees.
The "Register" link would take you to a page for registering a new employee.
