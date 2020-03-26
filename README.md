# Record-Management-System
Database Management Project

# Objective of this Assignment
  To design a miniature Project for a Banking Management System using Java, Oracle and
  JDBC.
# Requisite
  Completion of IDB Laboratory Assignment-4
  Basic Java Programming knowledge
  
# Overview of the Project
A Banking Management System is to be designed, putting together the
  concepts learnt in theory and practised in laboratory. The Project will integrate a Java frontend
  menu driven program to the backend Banking Database designed in Oracle through JDBC
connectivity.

# Project Description
The Java program provides an interface to the user to access, insert, delete
and update the database. The program handles user input, output to and from the database for the
said operations. User should be able to do the following operations:

1. Show Customer Records:
Using this option the details of all the customers should be displayed in particular
format.

2. Add Customer Record:
Using this option the user needs to provide the information such as cust_no, name, phoneno
and city through user input, which will be saved in database. After that using option 1,
details of all the customers will be displayed in particular format.

3. Delete Customer Record:
Using this option the user needs to provide the cust_no of a customer through user input and
all the information related to that customer will be deleted from the database. After that
using option 1, details of all the customers will be displayed in particular format.

4. Update Customer Information:
Using this option the user needs to provide the cust_no of a customer through user input and
based on the following choice the information related to the customer will be updated.
4.1: Update name
4.2: Update Phoneno.
4.3: Update city
After that using option 1, details of all the customers will be displayed in particular format.

5. Show Account Details of a Customer:
Using this option the user needs to provide the cust_no of a customer through user
input and all the information of that customer along with his account_no, type,
balance, branch_code, branch_name and branch_city will be displayed in proper
format.

6. Show Loan Details of a Customer:
Using this option the user needs to provide the cust_no of a customer through user
input and all the information of that customer along with his loan_no, loan amount,
branch_code, branch_name and branch_city will be displayed in proper format.

7. Deposit Money to an Account:
Using this option the user needs to provide the account_no of a customer and the amount to
be deposited through user input. According to the deposited amount the updated balance will
be verified in proper format using option 5.

8. Withdraw Money from an Account:
Using this option the user needs to provide the account_no of a customer and the amount to
be withdraw through user input. According to the withdraw amount the updated balance will
be verified in proper format using option 5.

9. Exit the Program
The operations are choice based. Appropriate option has to be chosen from a switch case based
menu driven program and the operation on the database is performed accordingly. The output is
displayed in the terminal screen with appropriate messages from the database as displayed by
Oracle during direct access. Exceptions should be handled properly by the Java program. The
output should be displayed in a formatted way for clarity of understanding and visual.
