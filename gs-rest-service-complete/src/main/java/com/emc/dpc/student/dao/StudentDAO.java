package com.emc.dpc.student.dao;

import java.util.List;

import com.emc.dpc.student.domain.Student;

public interface StudentDAO {

	Student getStudent(int rollNo);
	List<Student> getStudents();
	void enrollStudent(Student student);
	void enrollStudents(List<Student> students);
	
}
