package com.poineer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poineer.mapper.StuMapper;
import com.poineer.pojo.Student;
import com.poineer.service.StuService;

@Service("stuService")
@Transactional
public class StuServiceImpl implements StuService {

	@Autowired
	private StuMapper stuMapper;
	
	@Override
	public int addStu(Student student) {
		// TODO Auto-generated method stub
		return stuMapper.addStu(student);
	}

	@Override
	public int delStuByName(String sName) {
		// TODO Auto-generated method stub
		return stuMapper.delStuByName(sName);
	}

	@Override
	public Student findStuById(int sId) {
		// TODO Auto-generated method stub
		return stuMapper.findStuById(sId);
	}

	@Override
	public List<Student> findAllStus() {
		// TODO Auto-generated method stub
		return stuMapper.findAllStus();
	}

}
