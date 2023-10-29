package com.aurionpro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner{
private StudentDao studentDao;
	
	public Application(StudentDao studentdao) {
		super();
		this.studentDao = studentdao;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		
//		addNewStudent();
		findStudentById();
//		findAllStudents();
//		deleteStudentById();
		//findStudentByFirstName();
		//findStudentByFirstAndLastName();
		//	findStudentByEmailId();
//			updateStudent();
		}

		private void updateStudent() {
			Student student = new Student(2,"riya", "tejap", "riya@gmail.com");
			studentDao.updateStudent(student);
			
			
		}

		private void findStudentByEmailId() {
			String emailId="dhruv@gmail.com";
			List<Student> student=studentDao.findStudentByEmailId(emailId);
			System.out.println(student);
		}

		private void findStudentByFirstAndLastName() {
			String firstName="Harshal";
			String lastName="Tamboli";
			List<Student> students = studentDao.findStudentByFirstName(firstName,lastName);
			System.out.println(students);
		}
	private void findStudentByFirstName() {
		String firstName="tanuja";
		List<Student> students=studentDao.findStudentByFirstName(firstName);
		System.out.println(students);
		
	}
	private void deleteStudentById() {
		int id = 1;
		studentDao.deleteStudentById(id);
		
	}
	private void findAllStudents() {
		List <Student> students = studentDao.findAll();
		System.out.println(students);
		
	}
	private void findStudentById() {
		int id=2;
		Student student = studentDao.findStudentById(id);
		if(student!=null) {
			System.out.println(student);
			
		}else {
			System.out.println("Student with"+id+"not found");
		}
		
		
	}
	private void addNewStudent() {
		Student student = new Student("namrata","maahtre","namrata@gmail.com");
		studentDao.saveStudent(student);
		System.out.println("Student Save Successfully");
	}

}
