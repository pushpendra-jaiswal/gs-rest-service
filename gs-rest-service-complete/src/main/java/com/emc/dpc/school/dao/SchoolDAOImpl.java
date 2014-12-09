package com.emc.dpc.school.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.emc.dpc.school.domain.Designation;
import com.emc.dpc.school.domain.Grade;
import com.emc.dpc.school.domain.Dept;
import com.emc.dpc.employee.domain.Employee;
import com.emc.dpc.school.domain.School;
import com.emc.dpc.student.domain.Student;



@Repository
public class SchoolDAOImpl implements SchoolDAO{

	@PersistenceContext private EntityManager em;

	
	@Override
	public School getSchoolDetails() {
		
		String query = "from School";
		List<School> schoolList = em.createQuery(query).getResultList();
		if(schoolList == null || !(schoolList.size()>0))
		{
			School school = new School();
			List<Student> students =  new ArrayList<Student>();
			List<Employee> staff  =  new LinkedList<Employee>(); 
		
			Student student = new Student();
			student.setRollNo(1);
			student.setName("x");
			student.setGrade(Grade.I);
			students.add(student);
			school.setStudents(students);
			Employee employee = new Employee();
			employee.setName("y");
			employee.setRegNo(6);
			employee.setDesignation(Designation.TGT);
			employee.setDept(Dept.HINDI);
			staff.add(employee);
			school.setStaff(staff);
			em.persist(school);
			return school;
		}
		else
		{
			return schoolList.get(0);
		}
	}

	@Override
	public void updateSchoolDetails(School school) {
		em.merge(school);
	}
	

}
