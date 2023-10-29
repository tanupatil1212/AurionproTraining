package com.aurionpro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentDaoImpl implements StudentDao {
	private EntityManager manager;

	public StudentDaoImpl(EntityManager manager) {
	super();
	this.manager = manager;
}
    @Transactional
	@Override
	public void saveStudent(Student student) {
		manager.persist(student);
	}
	@Override
	public Student findStudentById(int id) {
		return manager.find(Student.class, id);
	}
	@Override
	public List<Student> findAll() {
		TypedQuery<Student>query =manager.createQuery("from Student",Student.class);
		return query.getResultList();
	}
	@Transactional
	public void deleteStudentById(int id) {
	    Student student = manager.find(Student.class, id);
	    if (student != null) {
	        manager.remove(student);
	        System.out.println("Student deleted successfully");
	    } else {
	        System.out.println("Could not find student");
	    }
	}
	
	@Override
	public List<Student> findStudentByFirstName(String firstName) {
		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.firstName = :firstName", Student.class);
	    query.setParameter("firstName", firstName); // Set the parameter value
	    return query.getResultList();
	}
	
	@Override
	public List<Student> findStudentByFirstName(String firstName, String lastName) {
		Query query = manager.createQuery("select s from Student s where s.firstName=?1 and s.lastName=?2");
		query.setParameter(1,firstName);
		query.setParameter(2,lastName);
		return query.getResultList();
	}

	@Override
	public List<Student> findStudentByEmailId(String emailId) {
		Query query = manager.createQuery("select s from Student s where s.emailId=?1");
		query.setParameter(1,emailId);
		return query.getResultList() ;
	}
     
	@Transactional
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		manager.merge(student);
		System.out.println("updated successfully");
	}


    

}
