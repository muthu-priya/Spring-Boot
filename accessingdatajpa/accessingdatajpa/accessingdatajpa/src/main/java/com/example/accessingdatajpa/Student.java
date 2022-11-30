package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String email;
    private long phoneNum;


    protected Student() {}

    public Student(String firstName, String email,long phoneNum) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%d, firstName='%s', email='%s', phoneNum='%d']",
                id, firstName, email,phoneNum);
    }

    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public long getPhoneNum(){
        return phoneNum;
    }
}
