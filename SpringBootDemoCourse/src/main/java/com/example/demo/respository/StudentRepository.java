package com.example.demo.respository;

import java.util.List;

import com.example.demo.student.Student;

public interface StudentRepository {

	public Student getSpecificStudent(int id);
	
	public Student addIndividualStudent(Student student);
	
	public Student addNewIndividualStudent(Student student);
	
	public Student findStudentByEmail(String email);
	
	public List<Student> getAllStudents();
	
	public void save(Student student);
	
	public void deleteOneStudent(int id);
	
	public Student updateStudentDetails(Student student,int id);
	
	public void updateStudent(Student student,int id);
}
