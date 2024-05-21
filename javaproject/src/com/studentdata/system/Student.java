package com.studentdata.system;

public class Student {
    String firstName;
    String lastName;
    long enrollment_No;
    short sem;
    short age;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getEnrollment_No() {
        return enrollment_No;
    }

    public void setEnrollment_No(long enrollment_No) {
        this.enrollment_No = enrollment_No;
    }

    public short getSem(short i) {
        return sem;
    }

    public void setSem(short sem) {
        this.sem = sem;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String toString() {
        return "FirstName: "+this.firstName+"\nLastname: "+this.lastName+"\nEnrollment No: "+this.enrollment_No+"\nSem: "+this.sem+"\nAge: " +this.age;
    }
}
