package com.poineer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.poineer.pojo.Student;

public interface StuMapper {

	public int addStu(Student student);
	
	public int delStuByName(@Param("sName")  String sName);
	
	public Student findStuById(int sId);

	public List<Student> findAllStus(); 
	
	
	
}
