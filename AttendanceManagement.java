package Management; 
import java.util.; 
import java.sql.; 
import java.lang.*; 
import java.util.Scanner;

public class Employee {

public static void main(String[] args) {
while(true) {
Scanner sc = new Scanner(System.in);
String dbUrl = "jdbc:mysql://localhost:3306/attendance";
String username = "";//Your user_name
String password = "";//Your Password
try {
Connection myConn = DriverManager.getConnection(dbUrl,username,password);
Statement stmt = myConn.createStatement();
System.out.println("Connection established");
//Once if table is created just comment it
/*String table = "CREATE table employee(emp_id int, first_name varchar(255),last_name varchar(255),Age int,primary key (emp_id))";
stmt.executeUpdate(table);
System.out.println("Table created successfully");
*/	
System.out.println("ATTENDANCE MANAGEMENT SYSTEM");
System.out.println("1.Insert a record");
System.out.println("2.Delete a record");
System.out.println("3.To chech whether the employee is present or not");
System.out.println("4.Exit");
System.out.println("Enter the number to perform:");
int num = sc.nextInt();
switch(num){
case 1:
	insert();
	break;
case 2:
	delete();
	break;
case 3:
	present();
	break;
case 4:
	System.out.println("Exit from the loop");
	System.exit(0);
	
	break;
	
default:
	break;
}
}catch(Exception ex) {
	System.out.print(ex);
}
} } static void insert() { String dbUrl = "jdbc:mysql://localhost:3306/attendance"; String username = "root"; String password = "root";

	try {
	Connection myConn = DriverManager.getConnection(dbUrl,username,password);
	Statement stmt = myConn.createStatement();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter employee id:");
	int id = sc.nextInt();
	System.out.println("Enter employee first name:");
	String firstname = sc.next();
	System.out.println("Enter employee last name:");
	String lastname = sc.next();
	System.out.println("Enter age of the employee");
	int age = sc.nextInt();

	String insert = "INSERT into employee VALUES('"+id+"','"+firstname+"','"+lastname+"','"+age+"')";
	stmt.executeUpdate(insert);
	System.out.print("Inserted");
	
}catch(Exception ex) {
	System.out.println(ex);
}
} static void delete() { String dbUrl = "jdbc:mysql://localhost:3306/attendance"; String username = "root"; String password = "root";

	try {
	Connection myConn = DriverManager.getConnection(dbUrl,username,password);
	Statement stmt = myConn.createStatement();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the employee id to delete:");
	int id = sc.nextInt();
	String  delete = "DELETE from employee where emp_id ='"+id+"'";
    stmt.execute(delete);
    System.out.println("Deleted Successfully");
	
}catch(Exception ex) {
	System.out.println(ex);
}
} static void present() { String dbUrl = "jdbc:mysql://localhost:3306/attendance"; String username = "root"; String password = "root";

	try {
	Connection myConn = DriverManager.getConnection(dbUrl,username,password);
	Statement stmt = myConn.createStatement();
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the employee id to check presence or absence");
	int id = sc.nextInt();
	
	String select = "SELECT * from employee where emp_id = '"+id+"'";
	ResultSet rs = stmt.executeQuery(select);
	
	if(rs.next()) {
		System.out.println("Empoyee_id:"+rs.getInt("emp_id"));
		System.out.println("First_name:"+rs.getString("first_name"));
		System.out.println("Last_name:"+rs.getString("last_name"));
		System.out.println("Age:"+rs.getInt("Age"));
		System.out.println("Empoloee was Present");
	}
	else {
		System.out.print("Absent");
	}
}catch(Exception ex) {
	System.out.println(ex);
}
} }