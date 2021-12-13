package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.respository.StudentRepository;
import com.example.demo.student.Student;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student getStudents(int id)
	{
		Student student1=studentRepository.getSpecificStudent(id);
		if(student1!=null)
		{
			System.out.println("We  found student with given id "+id);
			return student1;	
		}
		else
		{
			System.out.println("We didn't find student with such id "+id);
			return null;
		}
		
	}
	
	@Transactional
	public Student addOneStudent(Student student)
	{
		//Student student=new Student();
		student.setId(student.getId());
		student.setName(student.getName());
        student.setEmail(student.getEmail());
        student.setAge(student.getAge());
        student.setDob(student.getDob());
		studentRepository.addIndividualStudent(student);
		return student;
	}
	
	@Transactional
	public Student addNewStudent(Student student)
	{
		//Student student=new Student();
		student.setId(student.getId());
		student.setName(student.getName());
        student.setEmail(student.getEmail());
        student.setAge(student.getAge());
        student.setDob(student.getDob());
   /*   Optional<Student> opt=studentRepository.findStudentByEmail("nowshadbalu@gmail.com")
        
        if(opt.isPresent())
        {
        	throw new IllegalStateException("Email already taken");
        }*/
        
        studentRepository.save(student);

		return student;
	}
	
	@Transactional
	public List<Student> getAllStudents()
	{
		return studentRepository.getAllStudents();
	}
	
	@Transactional
	public void deleteStudentById(int id)
	{
		studentRepository.deleteOneStudent(id);
		return ;
	}
	
	@Transactional
	public Student updateDetails(Student student,int id)
	{
		Student student1=studentRepository.updateStudentDetails(student,id);
		
		return student1;
	}
	
	@Transactional
	public void updateStudent(Student student,int id)
	{
		studentRepository.updateStudent(student,id);
		
	}
}
