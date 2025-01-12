package com.cjc.SpringbootCrudapplication3.StudentServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.SpringbootCrudapplication3.Model.Student;
import com.cjc.SpringbootCrudapplication3.StudentServiceI.StudentServiceI;
import com.cjc.SpringbootCrudapplication3.repositary.StudentRepositary;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepositary sr;

	@Override
	public Student saveStudent(Student s) {

		return sr.save(s);

	}

	@Override
	public List<Student> loginStudent(String username, String password) {

		if (username.equals("ADMIN") && password.equals("ADMIN")) {
			return (List<Student>) sr.findAll();
		} else {
			return sr.findByUsernameAndPassword(username, password);
			
		}

	}

	@Override
	public void deleteStudent(Student s) {
		sr.delete(s);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return (List<Student>) sr.findAll();
	}

	@Override
	public Student editStudent(int rollno) {
		
		return sr.findByRollno(rollno);
	}
	
	
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sr.save(s);
		
	}

	@Override
	public List<Student> pagingStudent(int pageNo) {
		

		Pageable pegeable=PageRequest.of(pageNo, 2, Sort.by("name").ascending());
		
		return sr.findAll(pegeable).toList();
	}
	@RequestMapping("logout")
	public String logout()
	{
		return"login";
	}
}
