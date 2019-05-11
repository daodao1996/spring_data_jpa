package com.example.employee.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name = "age",nullable = false)
    private int age;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "companyId",nullable = false)
    private int companyId;
    @Column(name = "salary",nullable = false)
    private int salary;

    public Employee(){}

    public Employee(int id,String name,int age,String gender,int companyId,int salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
