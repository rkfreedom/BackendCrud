package com.cjc.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.Service.ServiceInter;
import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepositary;

@Service
public class ServiceImpl implements ServiceInter {

	@Autowired
	HomeRepositary hr;
	
	@Override
	public void saveData(Student s) {

		hr.save(s);
	}

	@Override
	public Student checklogin(String u, String p) {

		
		return hr.findAllByUsernameAndPassword(u, p);
	}

	@Override
	public Iterable displayAllData() {

		return hr.findAll();
	}

	@Override
	public void deleteStudent(Student m) {
		
		hr.delete(m);
	}

	@Override
	public Student editPage(int id) {

		return hr.findAllById(id);
	}
}
