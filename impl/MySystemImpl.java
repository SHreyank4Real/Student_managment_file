package impl;
import java.sql.*;
import java.util.ArrayList;

import interfaces.MySystem;
import valObject.Faculty;
import valObject.Mentor;
import valObject.Student;

public class MySystemImpl implements MySystem {
	
	@Override
	public void addStudent(Student sObj) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		
		int num = sObj.getRollNo();;
		String name = sObj.getName();
		String ban = sObj.getBranch();
		String insert = "Insert into students(roll_num,sname,branch) values ("+num+",'"+name+"','"+ban+"')";
		try {
			st.executeUpdate(insert);
		}catch(Exception e) {
			System.out.println("Error while adding");
			System.exit(0);
		}
		System.out.println("Inserting Complete");
		
		st.close();
		con.close();
		
	}
	@Override
	public void addFaculty(Faculty fObj) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		
		String name = fObj.getName();
    	int fid = fObj.getFID();
    	String dept = fObj.getDept();
    	
		String insert = "Insert into faculties(fac_id,fname,department) values ("+fid+",'"+name+"','"+dept+"')";
		try {
			st.executeUpdate(insert);
		}catch(Exception e) {
			System.out.println("Error while adding");
			System.exit(0);
		}
		System.out.println("Inserting Complete");
		
		st.close();
		con.close();
	}
	
	@Override
	public void addMentor(Mentor mObj) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		
		int fid = mObj.getFID();
    	int regno = mObj.getRegNo();
    	
		String insert = "Insert into mentor(fid,snum) values ("+fid+","+regno+")";
		try {
			st.executeUpdate(insert);
		}catch(Exception e) {
			System.out.println("Error while adding");
			System.exit(0);
		}
		System.out.println("Inserting Complete");
		
		st.close();
		con.close();
		
	}
	@Override
	public void removeStudent(int regno) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		int times = 0;
		
		String stmt = "delete from students where roll_num="+regno;
		try {
			times = st.executeUpdate(stmt);
		}catch(Exception e) {
			System.out.println("Error While Removing");
		}
		System.out.println("Changed "+times+" rows");
		System.out.println("Deleted");
		st.close();
		con.close();
		
	}
	@Override
	public void removeFaculty(int fid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		int times = 0;
		
		String stmt = "delete from faculties where fac_id="+fid;
		try {
			times = st.executeUpdate(stmt);
		}catch(Exception e) {
			System.out.println("Error While Removing");
		}
		System.out.println("Changed "+times+" rows");
		System.out.println("Deleted");
		st.close();
		con.close();
		
	}
	@Override
	public void removeMentor(int regno) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		int times = 0;
		
		String stmt = "delete from mentor where fid="+regno;
		try {
			times = st.executeUpdate(stmt);
		}catch(Exception e) {
			System.out.println("Error While Removing");
		}
		System.out.println("Changed "+times+" rows");
		System.out.println("Deleted");
		st.close();
		con.close();
		
	}

	@Override
	public ArrayList<String> displayStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		ArrayList<String> lines = new ArrayList<String>();
		
		ResultSet rs = st.executeQuery("SELECT * FROM students");
		
		while(rs.next()) {
			lines.add(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
		return lines;
	}
	@Override
	public ArrayList<String> displayFaculty() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		ArrayList<String> lines = new ArrayList<String>();
		
		ResultSet rs = st.executeQuery("SELECT * FROM faculties");
		
		while(rs.next()) {
			lines.add(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
		return lines;
	}
	@Override
	public ArrayList<String> displayMentor() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://52.11.249.238:3306/labs","181047005","181047005");
		Statement st = con.createStatement();
		ArrayList<String> lines = new ArrayList<String>();
		
		ResultSet rs = st.executeQuery("SELECT * FROM mentor");
		
		while(rs.next()) {
			lines.add(rs.getInt(1)+" "+rs.getString(2));
		}
		
		rs.close();
		st.close();
		con.close();
		return lines;
	}
	   
	   
}
