package com.aurionpro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional 
@Repository 
public class StudentRepositaryImpl implements StudentRepository{

	
	private EntityManager manager;
	
	public StudentRepositaryImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public List<Student> findAll() {
//		TypedQuery<Student> query = manager.createQuery("from Student",Student.class);
		Query query = manager.createNativeQuery("select * from student");
		return query.getResultList();
		
	}

	@Override
	public Student findById(int studentId) {
		
		return manager.find(Student.class, studentId);
//		Query query = manager.createNamedQuery("findStudent");
//		query.setParameter(1, studentId);
//		return (Student) query.getSingleResult();
	}

	@Override
	public Student saveStudent(Student student) {
		manager.persist(student); 
		  return manager.find(Student.class, student.getId()); 
	}

	@Override
	public Student updateStudent(Student student) {
		return manager.merge(student); 
	}

	@Override
	public void deleteStudentById(int studentId) {
		Student student = manager.find(Student.class, studentId);
		if(student!=null) 
		{
			manager.remove(student);
			System.out.println(student);			
		}else {
			System.out.println("Could not find Student");
		}
		
	}

	
	 
	 
	


}

	


