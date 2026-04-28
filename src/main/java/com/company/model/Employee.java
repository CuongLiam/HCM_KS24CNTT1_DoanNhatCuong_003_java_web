package com.company.model;

public class Employee {
    private Long id;
    private String fullName;
    private String position;
    private Double salary;
    private String hireDate;
    private String email;

    public Employee() {}

    public Employee(Long id, String fullName, String position,
                    Double salary, String hireDate, String email) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}