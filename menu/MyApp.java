package menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import valObject.Faculty;
import valObject.Student;
import valObject.Mentor;
import impl.MySystemImpl;
import interfaces.MySystem;

public class MyApp{
	static Date date = new Date();
	public static void main(String arg[]) throws Exception {
		Scanner Scan = new Scanner(System.in);
		int ch = 1;
		while(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6||ch==7||ch==8||ch==9||ch==0){
			
			System.out.println("\t1: Add Student Details\n\t2: Add Faculty Details\n\t3: Add Mentor\n\t4: Remove a Student\n\t5: Remove a Faculty\n\t6: Remove Mentor\n\t7: Display Student\n\t8: Display Faculty\n\t9: Display Mentor\n\t0:exit");
			System.out.println("Enter your Choice: ");
		    ch = Integer.parseInt(Scan.nextLine());
			switch(ch) {
				case 1:GetStudent();
						break;
				case 2:GetFaculty();
						break;
				case 3:GetMentor();
						break;
				case 4:GetStudentId();
						break;
				case 5:GetFacultyId();
						break;
				case 6:GetStdId();
						break;
				case 7:ShowStudent();
						break;
				case 8:ShowFaculty();
						break;
				case 9:ShowMentor();
						break;
				case 0:System.exit(0);
				default:System.out.println("Write Valid input");
			}
		}
		Scan.close();
	}
	
	

	private static void ShowMentor() throws Exception {
		MySystem myst = new MySystemImpl();
		ArrayList<String> Mlines = myst.displayMentor();
		System.out.println("FacultyID,StudentRegNO");
		for(String Line:Mlines) {
			System.out.println(Line);
		}
	}

	private static void ShowFaculty() throws Exception {
		MySystem myst = new MySystemImpl();
		ArrayList<String> Flines = myst.displayFaculty();
		System.out.println("FacultyID,FacultyName,Department");
		for(String Line:Flines) {
			System.out.println(Line);
		}
	}

	private static void ShowStudent() throws ClassNotFoundException, SQLException {
		MySystem myst = new MySystemImpl();
		ArrayList<String> Slines = myst.displayStudent();
		System.out.println("RollNumber,StudentName,Branch");
		for(String Line:Slines) {
			System.out.println(Line);
		}
	}

	private static void GetStdId() throws Exception {
		MySystem myst = new MySystemImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the faculty id to Remove");
		int regNo = scan.nextInt();
		myst.removeMentor(regNo);
	}

	private static void GetFacultyId() throws Exception {
		MySystem myst = new MySystemImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Faculty ID to Remove");
		int fid = scan.nextInt();
		myst.removeFaculty(fid);
	}

	private static void GetStudentId() throws Exception {
		MySystem myst = new MySystemImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Reg Number to Remove");
		int regNo = scan.nextInt();
		myst.removeStudent(regNo);
	}

	private static void GetMentor() throws SQLException, ClassNotFoundException {
		MySystem myst = new MySystemImpl();	
		Scanner scan = new Scanner(System.in);
		Mentor mt = new Mentor();
		System.out.println("Enter the Faculty ID");
		mt.setFID(scan.nextInt());
		System.out.println("Enter the Student RegNo");
		mt.setRegNo(scan.nextInt());
		myst.addMentor(mt);
	}

	private static void GetFaculty() throws Exception {
		MySystem myst = new MySystemImpl();	
		Scanner scan = new Scanner(System.in);
		Faculty ft = new Faculty();
		System.out.println("Enter the Faculty Name");
		ft.setName(scan.nextLine());
		System.out.println("Enter The Department");
		ft.setDept(scan.nextLine());
		System.out.println("Enter the Faculty RegNo");
		ft.setFID(scan.nextInt());
		myst.addFaculty(ft);
		
	}

	private static void GetStudent() throws Exception {
		MySystem myst = new MySystemImpl();	
		Scanner scan1 = new Scanner(System.in);
		Student st = new Student();
		System.out.println("Enter the Student Name");
		String name = scan1.nextLine();
		st.setName(name);
		System.out.println("Enter the Student Course");
		String course = scan1.nextLine();
		System.out.println("Enter the Student RegNo");
		int reg = scan1.nextInt();
		st.setRollNo(reg);
		st.setBranch(course);
		myst.addStudent(st);	
	}	
}
