package com.poineer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.poineer.pojo.Student;
import com.poineer.service.StuService;

@Controller
@RequestMapping(value="/stuController")
public class StuController {

	@Autowired
	private StuService stuService;
	
	
	@RequestMapping("/myIndex")
    public ModelAndView myIndex(){
		 ModelAndView mav = new ModelAndView();
		  mav.setViewName("myTest");
		return mav;
    }
	
	@RequestMapping(value="/addStu")
	@ResponseBody
    public int addStu(Student student){
		
		return stuService.addStu(student);
	}
	
	@RequestMapping(value="/delStuByName")
	@ResponseBody
	public int delStuByName(String sName){
		return stuService.delStuByName(sName);
	}
	
	@RequestMapping(value="/findStuById")
	@ResponseBody
	public Student findStuById(int sId){
		return stuService.findStuById(sId);
	}

	@RequestMapping(value="/findAllStus")
	@ResponseBody
	public List<Student> findAllStus(){
		return stuService.findAllStus();
	}
}
