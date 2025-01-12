package com.cjc.SpringbootCrudapplication3.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjc.SpringbootCrudapplication3.Model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>{

	List<Student> findByUsernameAndPassword(String username, String password);
	
	public Student findByRollno(int rollno);
	
//	@Transactional
//	@Modifying
//	@Query(name="delete",value="delete from Student where rollno=?1")
//	public void deleteData(int rollno);
//	
	
	@Transactional
	@Modifying
	
	public void deleteDataByRollno(int rollno);
	
	@Transactional
	@Modifying
	@Query(value = "update Student set name=:nm,username=:u,password=:p where rollno=:id")
	public void updateData(@Param("nm") String name,@Param("u") String username,@Param("p") String password,@Param("id") int rollno);

	

	
}
