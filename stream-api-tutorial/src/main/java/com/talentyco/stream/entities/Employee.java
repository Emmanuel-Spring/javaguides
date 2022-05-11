package com.talentyco.stream.entities;

import java.util.List;

public class Employee {

    private String firstName;
    private String lasttName;
    private Double salary;
    private List<String > projects;

    public Employee() {
    }

    public Employee(String firstName, String lasttName, Double salary, List<String> projects) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.salary = salary;
        this.projects = projects;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lasttName='" + lasttName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

}
