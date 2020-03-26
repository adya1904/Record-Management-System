import java.sql.*;


import java.io.*;

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		int choice;
		// Declare common variables if any
		try {
			// Load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create the connection object
			
			String conurl="jdbc:oracle:thin:@172.17.144.110:1521:ora11g";
			con=DriverManager.getConnection(conurl,"ite1741017012","ite1741017012");
			stmt = con.createStatement();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("\n\n***** Banking Management System*****");
				// Display the menu
				System.out.println("1. Display Customer Records.");
				System.out.println("2. Add Customer Record");
				System.out.println("3. Delete Customer Record");
				System.out.println("4. Update Customer Record");
				System.out.println("5. Display Account Details");
				System.out.println("6. Display Loan Details");
				System.out.println("7. Deposit Money");
				System.out.println("8. WithDraw Money");
				System.out.println("9. Exit");

				System.out.println("Enter your choice(1-9):");

				choice = Integer.parseInt(br.readLine());
				// Accept user's choice
				switch (choice) {
				case 1:
					// Display customer records
					try {
						String sql = "SELECT * FROM CUSTOMER;";
						ResultSet rs = stmt.executeQuery(sql);
						while (rs.next()) {
							System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" +  rs.getString(4));
						}
					} catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 2:
					// Add customer record
					// Accept input for each column from user

					System.out.print("Enter Customer number : ");
					String cust_no = br.readLine();
					System.out.println();
					System.out.print("Enter Customer Name : ");
					String cust_name = br.readLine();
					System.out.println();
					System.out.println("Enter Phone Number : ");
					String cust_phone = br.readLine();
					System.out.print("Enter Customer City : ");
					String cust_city = br.readLine();
					

					try {
						String sql = "INSERT INTO CUSTOMER (CUST_NO, CUST_NAME, CUST_NUM, CUST_CITY) " + "VALUES" + "( " + "'"
								+ cust_no + "'" + "," + "'" + cust_name + "'" + "," + "'" + cust_phone + "'" + "," +  "'" + cust_city + "'" + ");";

						stmt.executeUpdate(sql);
						System.out.println("Inserted Successfully");
					} catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 3:
					// Delete customer record
					// Accept customer number from user
					System.out.print("Enter Customer Number to delete : ");
					String delete_no = br.readLine();
					try {
						String sql_check = "SELECT * FROM CUSTOMER WHERE CUST_NO = "  + "'" + delete_no + "'" + ";";
						ResultSet rs = stmt.executeQuery(sql_check);
						
						if (!rs.next()) {
							System.out.println("No customer exists!");
						}  else {
							String sql = "DELETE FROM CUSTOMER WHERE CUST_NO = " + "'" + delete_no + "'" + ";";
							stmt.executeUpdate(sql);
							System.out.println("Deleted Successfully");
						}
					} catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 4:
					// Update customer record
					// Accept customer number from user
					System.out.print("Enter customer number to update records : ");
					String update_no = br.readLine();
					System.out.println();
					System.out.println("Enter 1: For Name 2: For Phone no 3: For City to update:");
					// Accept user's choice
					choice = Integer.parseInt(br.readLine());

					switch (choice) {
					case 1:
						// Update customer's name
						System.out.print("Enter new name : ");
						String new_name = br.readLine();

						try {
							String sql = "UPDATE CUSTOMER SET CUST_NAME = " + "'" + new_name + "'" + "WHERE CUST_NO = "
									+ "'" + update_no + "'" + ";";
							stmt.executeUpdate(sql);
							System.out.println("Updated Successfully");
						} catch (Exception e) {
							System.out.println("Sorry, error occured.");
							System.out.println("Message : " + e);
						}
						break;
					case 2:
						// Update customer's phone number
						System.out.print("Enter new number : ");
						String new_number = br.readLine();

						try {
							String sql = "UPDATE CUSTOMER SET CUST_NUM = " + "'" + new_number + "'" + "WHERE CUST_NO = "
									+ "'" + update_no + "'" + ";";
							stmt.executeUpdate(sql);
							System.out.println("Updated Successfully");
						} catch (Exception e) {
							System.out.println("Sorry, error occured.");
							System.out.println("Message : " + e);
						}
						break;
					case 3:
						// Update customer's city
						System.out.print("Enter new city : ");
						String new_city = br.readLine();

						try {
							String sql = "UPDATE CUSTOMER SET CUST_CITY = " + "'" + new_city + "'" + "WHERE CUST_NO = "
									+ "'" + update_no + "'" + ";";
							stmt.executeUpdate(sql);
							
							System.out.println("Updated Successfully");
						} catch (Exception e) {
							System.out.println("Sorry, error occured.");
							System.out.println("Message : " + e);
						}
						break;
					}
					break;
				case 5:
					// Display account details
					// Accept customer number from user
					System.out.print("Enter Customer Number : ");
					String detail_no = br.readLine();
					try {
						String sql = "SELECT * FROM ACCOUNT NATURAL JOIN DEPOSITOR WHERE CUST_NO = " + "'" + detail_no
								+ "'" + ";";
						ResultSet rs = stmt.executeQuery(sql);
						if (!rs.next()) {
							System.out.println("No account exists!!");
						}
						while (rs.next()) {
							System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
									+ "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5));
						}
					}catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 6:
					// Display loan details
					// Accept customer number from user
					// Display the number of loans the customer has or
					// Congratulation if he customer has no loan
					System.out.print("Enter Customer Number : ");
					String loan_detail = br.readLine();
					try {
						String sql_check = "SELECT * FROM CUSTOMER WHERE CUST_NO = "  + "'" + loan_detail + "'" + ";";
						ResultSet rs = stmt.executeQuery(sql_check);
						
						if (!rs.next()) {
							System.out.println("No customer exists!");
						} else {

						String sql = "SELECT * FROM LOAN WHERE CUST_NO = " + "'" + loan_detail + "'" + ";";
						rs = stmt.executeQuery(sql);

						if (rs.next() == false) {
							System.out.println("Congratulation !! You have no loans.");
						} else {
							System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
									+ "\t\t" + rs.getString(4));
						}
						while (rs.next()) {
							System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
									+ "\t\t" + rs.getString(4));
						}
						}

					}catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 7:
					// Deposit money
					// Accept the account number to be deposited in
					// Message for transaction completion
					System.out.print("Enter Account Number : ");
					String account_no = br.readLine();
					System.out.print("Enter amount to be deposited : ");
					int amount = Integer.parseInt(br.readLine());

					try {
						String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = " + "'" + account_no + "'" + ";";
						ResultSet rs = stmt.executeQuery(sql);
						if (!rs.next()) {
							System.out.println("No account exists!!");
						}
						if (amount >= 100) {
							while (rs.next()) {
								int present_amount = Integer.parseInt(rs.getString(1));
								amount = amount + present_amount;
								String upd = "UPDATE ACCOUNT SET BALANCE = " + "'" + amount + "'"
										+ "WHERE ACCOUNT_NO = " + "'" + account_no + "'" + ";";
								stmt.executeUpdate(upd);
								System.out.println("Money Deposited Successfully");
							}
						} else {
							System.out.println("Invalid Amount");
						}

					}catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}
					break;
				case 8:
					// Withdraw money
					// Accept the account number to be withdrawn from
					// Handle appropriate withdral ckeck conditions
					// Message for transaction completion
					
					// Message for transaction completion
					System.out.print("Enter Account Number : ");
					account_no = br.readLine();
					System.out.print("Enter amount to be withdraw : ");
					amount = Integer.parseInt(br.readLine());
					
					try {
						String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = " + "'" + account_no + "'" + ";";
						ResultSet rs = stmt.executeQuery(sql);
						if (!rs.next()) {
							System.out.println("No account exists!!");
						}
						if (amount >= 100) {
							while (rs.next()) {
								int present_amount = Integer.parseInt(rs.getString(1));
								if (present_amount <= amount) {
									System.out.println("You need to maintain minimum balance");
								} else {
								amount = present_amount - amount;
								String upd = "UPDATE ACCOUNT SET BALANCE = " + "'" + amount + "'"
										+ "WHERE ACCOUNT_NO = " + "'" + account_no + "'" + ";";
								stmt.executeUpdate(upd);
								System.out.println("Money withdraw Successfully");
								}
							}
						} else {
							System.out.println("Invalid Amount");
						}
					} catch (Exception e) {
						System.out.println("Sorry, error occured.");
						System.out.println("Message : " + e);
					}

					break;
				case 9:
					System.out.println("Have a nice day!");
					System.exit(0);
					break;
				default:
					// Handle wrong choice of option
					System.out.println("invalid Option");
				}
			} while (choice != 9);
			stmt.close();
		} // try closing
		catch (Exception e) { // Handling exception
			System.out.println("Sorry, error occured.");
			System.out.println("Message : " + e);
		}
	} // main closing
}// End class
