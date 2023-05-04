package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Student;

@Repository
public interface HomeRepositary extends CrudRepository<Student	, Integer> {

	public Student findAllByUsernameAndPassword(String u, String p);

	public Student findAllById(int id);
}
