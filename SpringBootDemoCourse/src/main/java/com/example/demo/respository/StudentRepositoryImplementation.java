package com.example.demo.respository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.student.Student;

@Repository
public class StudentRepositoryImplementation implements StudentRepository
{
	//	@Autowired
	//	private Student student;

	@Autowired
	private SessionFactory factory;

	@Override
	public Student getSpecificStudent(int id)
	{
		Student student=new Student();


		Session session=factory.openSession();

		student=session.get(Student.class,id);

		System.out.println("Details of Specific student: "+student);
		
		return student;

	}

	@Override
	public Student addIndividualStudent(Student student)
	{
		Session session=factory.openSession();
       //calling save method for saving the student object data in the database
		session.save(student);

		return student;
	}

	@Override
	public Student addNewIndividualStudent(Student student) {

		//Optional<Student> opt=studentRepository.
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		 //calling createQuery method for fetching all the students data available  in the database
		Query<Student>query=session.createQuery("from Student",Student.class);
		
		List<Student> students=query.getResultList();
		return students;
	}

	@Override
	public Student findStudentByEmail(String email) 
	{
		Session session=factory.openSession();
		
		Student student=new Student();
		
		student=session.get(Student.class, email);
		return student;
	}

	@Override
	public void save(Student student)
	{
		Session session=factory.openSession();
 //calling save method for saving the student object data in the database
		session.save(student);
		
		
	}

	@Override
	public void deleteOneStudent(int id)
	{
		try
		{
			Session session=factory.openSession();
			
			session.beginTransaction();
			
			Student student1=(Student)session.get(Student.class, id);
	 //calling delete method for deleting the student data in case if  available in the database
			session.delete(student1);
			
			session.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }

	@Override
	public Student updateStudentDetails(Student student,int id) 
	{
		Session session=factory.openSession();
		
		session.beginTransaction();
		
	    Student	student1=(Student)session.get(Student.class, id);
		if(student!=null)		
		{
			student1.setName(student.getName());
			student1.setEmail(student.getEmail());
			student1.setAge(student.getAge());
			student1.setDob(student.getDob());
		}

		 //calling update method for updating the student data in case if  available in the database
		session.update(student1);
		
		session.getTransaction().commit();
		
		return student1;
	}

	@Override
	public void updateStudent(Student student, int id) {

        Session session=factory.openSession();
		
		session.beginTransaction();
		
	    Student	student1=(Student)session.get(Student.class, id);
		
		if(student1!=null)
		
		{
			student1.setName(student.getName());
			student1.setEmail(student.getEmail());
			student1.setAge(student.getAge());
			student1.setDob(student.getDob());
			//calling update method for updating the student data in case if  available in the database
			session.update(student1);
		}
		session.getTransaction().commit();
		
		session.close();
	}
	
	
}
