package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByEmail(String Email);
    List<Student>findByfirstName(String firstName);
    List<Student>findByphoneNum(long phoneNum);
    Student findById(long id);
}
