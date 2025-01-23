package org.example;

public class Employee {
    private String Name;
    private int Age;
    private String Company;
    private String Id;
    private int Salary;

    public Employee(String name, int age, String company, String id, int salary) {
        Name = name;
        Age = age;
        Company = company;
        Id = id;
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Company='" + Company + '\'' +
                ", Id='" + Id + '\'' +
                ", Salary=" + Salary +
                '}';
    }
    /* public Private getString() {
        return String;
    }

    public int getSalary() {
        return Salary;
    }

    public int getAge() {
        return Age;
    }

    public void setString(Private string) {
        String = string;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public java.lang.String toString() {
        return "Employee{" +
                "String=" + String +
                ", Age=" + Age +
                ", String=" + String +
                ", String=" + String +
                ", Salary=" + Salary +
                '}';*/
    }

