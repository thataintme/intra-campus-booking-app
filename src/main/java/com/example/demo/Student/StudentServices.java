package com.example.demo.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServices {
	private StudentRepository studentRepository;

	@Autowired
	public StudentServices(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	

	public List<Student> getStudents(){
		return studentRepository.findAll();
		
	}



	public void addNewStudent(Student student) {
		Optional<Student> studentByRegno = studentRepository.findStudentByRegno(student.getRegno());
		if(studentByRegno.isPresent()){
			throw new IllegalStateException("Student with reg. number "+student.getRegno()+" is already registered");
		}
		studentRepository.save(student);
		System.out.println("Added student "+student);
	}



	public void deleteStudent(long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalStateException("Student with this ID does not exist");
		}
		studentRepository.deleteById(studentId);
	}


	@Transactional
	public void updateStudent(Long studentId, String regno, String name, String block, Integer room, Long phno) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with ID number " + studentId + " does not exist"));
		
		// System.out.println("OLD : "+student);
		// System.out.println("parameters : "+studentId + " " + regno+ " " + name+ " " + block+ " " + room+ " " + phno);

		if(regno != null && !regno.equals(student.getRegno())){
			student.setRegno(regno);

		}
		if(name != null && !name.equals(student.getName())){
			student.setName(name);

		}
		if(block != null && !block.equals(student.getBlock())){
			student.setBlock(block);

		}
		if(room != null && room!=student.getRoom()){
			student.setRoom((int)room);

		}
		if( phno!= null && phno!=student.getPhno()){
			student.setPhno((long)phno);

		}
		// System.out.println("NEW : " + student);
		studentRepository.save(student);
		// System.out.println("NEW AFTER SAVE : " + student);
	}
    
}
