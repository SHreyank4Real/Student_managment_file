package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import valObject.Faculty;
import valObject.Mentor;
import valObject.Student;

public interface MySystem {
	void addStudent(Student sObj) throws Exception;
	void addFaculty(Faculty fObj) throws Exception;
	void addMentor(Mentor mObj) throws SQLException, ClassNotFoundException;
	void removeStudent(int regno) throws Exception;
	void removeFaculty(int fid) throws Exception;
	void removeMentor(int regNo) throws Exception;
	ArrayList<String> displayStudent() throws ClassNotFoundException, SQLException;
	ArrayList<String> displayFaculty() throws Exception;
	ArrayList<String> displayMentor() throws Exception;
}
