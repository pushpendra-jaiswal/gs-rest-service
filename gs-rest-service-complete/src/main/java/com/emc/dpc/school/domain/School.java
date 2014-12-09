package com.emc.dpc.school.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emc.dpc.employee.domain.Employee;
import com.emc.dpc.student.domain.Student;

@Entity
@Table
public class School {

	@Id
	@GeneratedValue
	private int id;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Student> students;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Employee> staff;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Employee> getStaff() {
		return staff;
	}
	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}
}
