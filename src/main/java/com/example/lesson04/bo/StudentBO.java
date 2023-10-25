package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper; //mybatis
	
	@Autowired
	private StudentRepository studentRepository; //jpa
	

	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	//JPA
	//LESSON07 EX01
	//input:파라미터들
	//output: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) //@UpdateTimestamp가 있다면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	//input: id, dreamjob
	//output : 변경된 StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null); //orelse : 만약에 없으면 (null)로 세팅한다
		if (student != null) {
			//기존 값은 유지하고 세팅된 일부의 값(dreamJob)만 변경한다 => toBuilder
			student = student.toBuilder() //기존값을 유지
			.dreamJob(dreamJob)
			.build();
			
			//update
			student = studentRepository.save(student); //db update 후 다시 저장
		}
		
		return student; //null 또는 변경된 데이터
	}
	
	//input: id
	//output: x
	public void deleteStudentById(int id) {
		//방법 1
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		//방법 2
		Optional<StudentEntity>studentOptional = studentRepository.findById(id); //optional
		studentOptional.ifPresent(s -> studentRepository.delete(s)); //if문으로 검사한것과 같은 효과, 요즘 유행하는 문법
	}
}
