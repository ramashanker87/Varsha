package com.varsha.app.model;

public class Patient {

    String name;
    int age;
    String gender;
    String Id;
    String hospitalName;

    public Patient(String Id, String name, int age, String hospitalName, String gender) {
    }

    public String getName() {
        return name;
    }

  /*  public void setName(String name) {
        this.name = name;
    }*/

    public int getAge() {
        return age;
    }

    /*public void setAge(int age) {
        this.age = age;
    }*/

    public String getGender() {
        return gender;
    }

    /*public void setGender(String gender) {
        this.gender = gender;
    }*/

    public String getId() {
        return Id;
    }

   /* public void setId(String id) {
        Id = id;
    }*/

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

  /*  @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Id='" + Id + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }*/

    public Patient(){}

  /*  public Patient(String name, int age, String gender, String id, String hospitalName) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        Id = id;
        this.hospitalName = hospitalName;
    }*/
}
