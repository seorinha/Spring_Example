package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	//Spring Data JPA: JpaRepository
	
	//save(객체) - insert, update (id없으면 insert, 있으면 update)
	//findById() - select
	//delete(객체) - delete
	//findAll() - 전체 조회
	
	//JPQL문법 - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	public List<StudentEntity> findByStartingWith(String name);
	
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	//ex02/2
	//1. JPQL : DB에 직접 안가고 entity로 조회를 하고있다
	@Query(value = "select st from new_student st where st.dreamJob = :dreamJob") //진짜 쿼리문이 아니라 entity한테 조회하는걸 쿼리문처럼 만든 것
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
}
