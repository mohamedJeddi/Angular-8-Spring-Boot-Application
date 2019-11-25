package com.example.springbootemployeemock.domain;

import java.util.Objects;

public class Employe {

    private String empId;
    private String name;
    private String designation;
    private double salary;

    public Employe() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Double.compare(employe.salary, salary) == 0 &&
                Objects.equals(empId, employe.empId) &&
                Objects.equals(name, employe.name) &&
                Objects.equals(designation, employe.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name, designation, salary);
    }
}
