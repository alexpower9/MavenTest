package student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
	private final StudentRepository studentRepository;
	
	
	@Autowired
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}



	public List<Student> getStudent()
	{
		return this.studentRepository.findAll();
	}



	public void addNewStudent(Student student)
	{
		java.util.Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentByEmail.isPresent())
		{
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}



	public void deleteStudent(Long studentId)
	{
		boolean exists = studentRepository.existsById(studentId);
		
		if(!exists)
		{
			throw new IllegalStateException("Student does not exist with " + studentId);
		}
		
		studentRepository.deleteById(studentId);
	}
}
