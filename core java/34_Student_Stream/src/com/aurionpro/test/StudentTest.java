package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		List<Student> students=Arrays.asList(
				new Student(1,"Tanuja",67,Arrays.asList("Singing","cooking")),
				new Student(2,"Sneha",87,Arrays.asList("Reading","Drawing")),
				new Student(3,"Rasika",68,Arrays.asList("Hiking","Blogging")),
				new Student(4,"Gita",78,Arrays.asList("Gardening","Reading")),
				new Student(5,"Sita",46,Arrays.asList("Singing","cooking")),
				new Student(6,"reeta",75,Arrays.asList("Singing","cooking"))
				
				);
		
		Student highestPercentageStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getPercentage))
                .orElse(null);

        if (highestPercentageStudent != null) {
            System.out.println("Student with the highest percentage: " + highestPercentageStudent);
        } else {
            System.out.println("No students found.");
        }
        
        
        List<String>collect = students.stream()
				.map((student)->student.getHobbies())
				.flatMap((list)->list.stream())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(collect);
    }
		
	}


