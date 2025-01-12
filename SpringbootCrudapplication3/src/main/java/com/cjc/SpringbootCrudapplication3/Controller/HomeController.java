package com.cjc.SpringbootCrudapplication3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.cjc.SpringbootCrudapplication3.Model.Student;
import com.cjc.SpringbootCrudapplication3.StudentServiceI.StudentServiceI;



@Controller
public class HomeController {
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String prelogin()
	{
		return "login";
	}
	
	@RequestMapping("/openregi")
	public String preRegister()
	{
		return "register";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student s)
	{
		System.out.println("open first page");
		ssi.saveStudent(s);
		
		return"login";
	}
	
	@RequestMapping("/log")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m)
	{
	List<Student>	list=ssi.loginStudent(username,password);
	if(!list.isEmpty())
	{
	m.addAttribute("data", list);	
	return"success";
	}
	else
	{
		return"login";
	}
	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m)
	{
		
	List<Student> list= ssi.pagingStudent(pageNo);
	m.addAttribute("data", list);
		return "success";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@ModelAttribute Student s,Model m)
	{
	    ssi.deleteStudent(s);
	    
	    List<Student>list=ssi.getAllStudent();
	    
		m.addAttribute("data", list);
		return"success";
	}
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno") int rollno,Model m)
	{
		Student s = ssi.editStudent(rollno);
		m.addAttribute("stu", s);
		return "edit";
	}
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m)
	{
		 ssi.saveStudent(s);
	List<Student>list=ssi.getAllStudent();
	m.addAttribute("data", list);
	return "success";
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return"login";
	}
	
    
	
}
