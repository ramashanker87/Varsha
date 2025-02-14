package com.varsha.app.model;

    public class Patient {

        private String name;
        private String id;
        private String hospitalName;
        private int age;
        private String gender;

        public Patient(String name, String id, String hospitalName, int age, String gender) {
            this.name = name;
            this.id = id;
            this.hospitalName = hospitalName;
            this.age = age;
            this.gender = gender;
        }

        public Patient() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
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

        @Override
        public String toString() {
            return "Patient{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", hospitalName='" + hospitalName + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

