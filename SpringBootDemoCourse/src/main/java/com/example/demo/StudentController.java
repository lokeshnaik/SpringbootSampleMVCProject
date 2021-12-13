package com.example.demo;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.respository.StudentRepositoryImplementation;
import com.example.demo.student.Student;

@RestController
//@ControllerAdvice 
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
		
	
	//For getting data from the server side we use this annotation
	@GetMapping("/{id}/")
	public Student getStudents(@PathVariable int id)
	{
   Student  student=studentService.getStudents(id);
   return student;
	}
	
	

	//For posting data on server side we use this annotation
	//@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student)
	{

		 student= studentService.addOneStudent(student);
		 
		 return student;
		
	}
	
	@PostMapping("/addNewStudent")
	public Student addNewStudent(@RequestBody Student student)
	{	   
	   student=studentService.addNewStudent(student);
	   
		return student;
	}
	
	//Getting all the students from the server side 
	@GetMapping("/getAllStudents")
	public List<Student> getStudents()
	{
		List<Student>student=studentService.getAllStudents();
		return student;
	}
	
	//Deleting a student using specific id
	@DeleteMapping("/delete/{id}/")
	public String deleteStudent(@PathVariable int id) throws Exception
	{
		Student student=studentService.getStudents(id);
		
		if(student==null)
		{
			throw new Exception("Student id not found "+ id);
		}
		
		studentService.deleteStudentById(id);
		return "Deleted student with id="+id ;
	}
	
	//Updating a student details and returning student response
	@PutMapping("/update/{id}")
	public  Student updatingStudentDetails(@RequestBody Student student,@PathVariable int id) throws Exception
	{
		// student=studentService.getStudents(id);
		if(student==null)
		{
	     throw new Exception();
		}
	  Student  student1=studentService.updateDetails(student,id);
	  
		return student1;
	} 
	
	//Updating the student details and returning void
	@PutMapping("/updating/{id}/")
	public void updateStudentDetails(@RequestBody Student student,@PathVariable int id) throws Exception
	{
	     studentService.updateStudent(student,id);
	
	}

}
