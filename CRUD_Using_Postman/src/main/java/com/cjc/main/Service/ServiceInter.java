package com.cjc.main.Service;

import com.cjc.main.model.Student;

public interface ServiceInter {

	void saveData(Student s);

	Student checklogin(String u, String p);

	Iterable displayAllData();

	void deleteStudent(Student m);

	Student editPage(int id);

}
