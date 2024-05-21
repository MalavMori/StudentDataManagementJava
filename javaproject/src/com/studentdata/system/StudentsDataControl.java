package com.studentdata.system;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsDataControl {
    ArrayList<Student> studentsdata;
    public StudentsDataControl(){
        studentsdata = ReadWriteData.ReadData();
    }
    boolean checkIsDuplicate(long en_no){
        for (Student s : studentsdata){
            if(s.enrollment_No == en_no){
                System.out.println("Enrollment is already present");
                return true;
            }

        }
        return false;
    }
    boolean isValidShort(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch (Exception e){
            System.out.println("Number is not valid");
            return false;
        }
    }
    boolean isValidEnrollment(String en_no){
        try{
            Long.parseLong(en_no);
            if (en_no.length() == 12) return true;
            System.out.println("Enrollment is not valid");
            return false;
        }catch (Exception e){
            System.out.println("Enrollment Number is not valid");
            return false;
        }
    }
    boolean isValidName(String str){
        if(str.chars().allMatch(Character::isLetter) && !str.isBlank()) return true;
        System.out.println("Name is not Valid");
        return false;
    }
    public void addStudent(){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter FirstName: ");
        String fname = input.nextLine();
        if (!isValidName(fname)) return;

        System.out.print("Enter LastName: ");
        String lname = input.nextLine();
        if (!isValidName(lname)) return;

        System.out.print("Enter Enrollment Number: ");
        String en_no = input.nextLine();
        if (!isValidEnrollment(en_no)) return;
        if (checkIsDuplicate(Long.parseLong(en_no))) return;

        System.out.print("Enter Sem: ");
        String sem = input.nextLine();
        if (!isValidShort(sem)) return;

        System.out.print("Enter Age: ");
        String age = input.nextLine();
        if (!isValidShort(age)) return;

        Student s = new Student();
        s.setFirstName(fname);
        s.setLastName(lname);
        s.setEnrollment_No(Long.parseLong(en_no));
        s.setSem(Short.parseShort(sem));
        s.setAge(Short.parseShort(age));

        studentsdata.add(s);
    }
    int findStudent(){
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Enrollment Number: ");
        Long en_no = input.nextLong();
        for (int i = 0; i< studentsdata.size();i++){
            if (en_no == studentsdata.get(i).enrollment_No){
                return i;
            }
        }
        System.out.println("Data Not Found");
        return -1;
    }
    public void updateStudent(){
        System.out.println();
        int studentIndex = findStudent();
        if(studentIndex != -1){
            Scanner input = new Scanner(System.in);
            System.out.println("1.Update Firstname");
            System.out.println("2.Update Lastname");
            System.out.println("3.Update Enrollment Number");
            System.out.println("4.Update Sem");
            System.out.println("5.Update Age");
            System.out.print("Enter What do you what to update: ");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1){
                System.out.print("Enter Firstname: ");
                String fname = new Scanner(System.in).nextLine();
                if (isValidName(fname)) studentsdata.get(studentIndex).setFirstName(fname);
                System.out.println(studentsdata.get(studentIndex));
                System.out.println("Updated");
            }
            else if (choice == 2) {
                System.out.print("Enter Lastname: ");
                String lname = new Scanner(System.in).nextLine();
                if (isValidName(lname)) studentsdata.get(studentIndex).setLastName(lname);
                System.out.println("Updated");
                System.out.println(studentsdata.get(studentIndex));
            }
            else if (choice == 3) {
                System.out.print("Enter Enrollment Number: ");
                Long en_no = new Scanner(System.in).nextLong();
                if (isValidEnrollment(String.valueOf(en_no))) studentsdata.get(studentIndex).setEnrollment_No(en_no);
                System.out.println("Updated");
                System.out.println(studentsdata.get(studentIndex));
            }
            else if (choice == 4) {
                System.out.print("Enter Sem: ");
                short sem = new Scanner(System.in).nextShort();
                if (isValidShort(String.valueOf(sem))) studentsdata.get(studentIndex).setSem(sem);
                System.out.println("Updated");
                System.out.println(studentsdata.get(studentIndex));
            }
            else if (choice == 5) {
                System.out.print("Enter Age: ");
                short age = new Scanner(System.in).nextShort();
                if (isValidShort(String.valueOf(age))) studentsdata.get(studentIndex).setAge(age);
                System.out.println("Updated");
                System.out.println(studentsdata.get(studentIndex));
            }
            else{
                System.out.println("Enter valid choice");
            }
        }
    }
    public void displayAllStudent(){
        System.out.println();
        for(Student s : studentsdata){
            System.out.println(s);
            System.out.println();
        }
    }
    public void searchStudent(){
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name or Enrollment No: ");
        String searchtag = input.nextLine();

        for(Student s : studentsdata){
            if (s.firstName.contains(searchtag) || s.lastName.contains(searchtag) ||
             String.valueOf(s.enrollment_No).contains(searchtag) ){
                System.out.println(s);
                System.out.println();
            }
        }
    }
    public void deleteStudent(){
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Enrollment No: ");
        long en_no = input.nextLong();
        for (int i = 0; i < studentsdata.size(); i++) {
            if (studentsdata.get(i).enrollment_No == en_no){
                System.out.println("This record deleted");
                System.out.println(studentsdata.remove(i));
                return;
            }
        }
    }
    public void save() throws FileNotFoundException {
        ReadWriteData.WriteData(studentsdata);
    }
}
