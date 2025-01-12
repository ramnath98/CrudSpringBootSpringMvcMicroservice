package com.cjc.SpringbootCrudapp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cjc.SpringbootCrudapplication3.Model.Student;
import com.cjc.SpringbootCrudapplication3.StudentServiceI.StudentServiceI;
import com.cjc.SpringbootCrudapplication3.repositary.StudentRepositary;


@SpringBootTest(classes = StudentServiceTest.class)
public class StudentServiceTest {
	
	

	@MockBean 
	StudentRepositary sr;
	
	@Autowired
	StudentServiceI  ssi;
	
	private Student st;
	
	@BeforeEach
    public void setUp() {
        System.out.println("setUp() ........");
        st = new Student(1, "pravin", 9881649658L, 98);
    }
	
	
	@AfterEach
    public void tearDown() {
        System.out.println("tear() ........");
        st = null;
       
    }
	
	
	@Test
	@DisplayName("SaveStudent_Testcase")
	public void test_saveStudent()
	{
		System.out.println("Save Student test case ........");
		when(sr.save(st)).thenReturn(st);
		assertEquals(st ,ssi.saveStudent(st));
		
	}
	
	@Test
	public void test_getSingleData()
	{
		System.out.println("test_getSingleData() ........");
		
		when(sr.findById(1)).thenReturn(Optional.of(st));
		assertEquals("pravin", ssi.editStudent(1).getName());
	}
	
	@Test
	public void test_getAllStudent()
	{
		System.out.println("Get all student test case");
		
	
		List<Student> stlist = Arrays.asList(new Student(1,"pravin",9881649658l,40.30),
				new Student(2,"Anant",9881649658l,20.30));
		
		
	when(sr.findAll()).thenReturn(stlist);
	
	assertEquals(2, stlist.size());
	}
	
//	public void test_deleteStudent()
//	{
//		System.out.println("delete student test case....");
//		ssi.deleteStudent(st);
//		verify(sr,times(1).delete(st));
//	}
	
	
	
	
	


}
