package com.cjc.SpringbootCrudapplication3.StudentServiceI;

import java.util.List;

import com.cjc.SpringbootCrudapplication3.Model.Student;

public interface StudentServiceI {

	public Student saveStudent(Student s);

	public List<Student> loginStudent(String username, String password);

	public void deleteStudent(Student s);

	public List<Student> getAllStudent();

	public Student editStudent(int rollno);

	public void addStudent(Student s);

	public List<Student> pagingStudent(int pageNo);

	
	
	

	
	
	
	
	

}
