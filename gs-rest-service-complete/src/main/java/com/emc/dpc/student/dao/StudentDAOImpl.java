package com.emc.dpc.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.emc.dpc.student.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@PersistenceContext private EntityManager em;

	
	@Override
	public Student getStudent(int rollNo) {

		String query = "from Student where rollNo = "+rollNo;
		List<Student> students = em.createQuery(query).getResultList();
		if(students != null && students.size()==1)
		{
			return students.get(0);
		}
		return null;
	}

	@Override
	public List<Student> getStudents() {
		String query = "from Student";
		List<Student> students = em.createQuery(query).getResultList();
		return students;
	}

	@Override
	public void enrollStudent(Student student) {
		em.persist(student);
	}

	@Override
	public void enrollStudents(List<Student> students) {

		for (Student student : students) {
			em.persist(student);
		}
	}

}
