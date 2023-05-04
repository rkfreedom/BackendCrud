package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.Service.ServiceInter;
import com.cjc.main.model.Student;

@RestController
public class HomeController {
	
	@Autowired
	ServiceInter si;
	
	//get all data
	@RequestMapping(value = "/getAllData",method = RequestMethod.GET)
	public Iterable getAllData() {
		
		Iterable list=si.displayAllData();
		
		return list;
	}
	
	//get single data
	@GetMapping(value = "/getsingledata/{username}/{password}")
	public Student getSingleData(@PathVariable("username") String user,@PathVariable("password") String pass) {
		
		Student s=si.checklogin(user,pass);
		return s;
	}
	
	//post method
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String regi(@RequestBody Student s) {
		
		si.saveData(s);
		
		return "done";
	}
	
	//put
	
	@PutMapping(value = "/updateData/{id}")
	public String update(@PathVariable ("id") int id, @RequestBody Student s) {
		
		si.saveData(s);
		
		return "done";
	}
	
	@DeleteMapping(value = "/deleteData/{id}")
	public String delete(@PathVariable ("id") int id, @RequestBody Student s) {
		
		si.deleteStudent(s);
		
		return "done";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/login")
	public String checklogin(@RequestParam ("username") String u, @RequestParam ("password") String p , Model m ) {
		
		System.out.println(u);
		System.out.println(p);
		
		si.checklogin(u,p);
		
		Iterable list=si.displayAllData();
		
		m.addAttribute("data", list);
		
		return"successful";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute Student m, Model md) {
		
		si.deleteStudent(m);
	Iterable list=si.displayAllData();
		
		md.addAttribute("data", list);
		return "successful";
	}
	
	@RequestMapping("/edit")
	public String editData(@RequestParam ("id") int id , Model m) {
		
		Student s=si.editPage(id);
		m.addAttribute("data", s);
		return "edit";
	}
	
//	@RequestMapping("/update")
//	public String updateData(@ModelAttribute Student s, Model md) {
//		
//		si.saveData(s);
//		Iterable list=si.displayAllData();
//		
//		md.addAttribute("data", list);
//		return "successful";
//	}
}
