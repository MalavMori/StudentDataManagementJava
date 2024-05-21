package com.studentdata.system;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadWriteData {
    public static void WriteData(ArrayList<Student> studentdb) throws FileNotFoundException {
        File csvfile = new File("studentdb.csv");
        PrintWriter out = new PrintWriter(csvfile);
        try{
            for (Student s : studentdb){
                out.println(s.firstName+","+ s.lastName+","+ s.enrollment_No+","+s.sem+","+ s.age);
            }
            System.out.println("Data saved");
        }catch (Exception e){
            System.out.println("Failed to save");
        }
        out.close();
    }
    public static ArrayList<Student> ReadData(){
        ArrayList<Student> studentsdata = new ArrayList<Student>();
        BufferedReader reader;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader("studentdb.csv"));
            while ((line = reader.readLine()) != null){
                String [] row = line.split(",");
                Student student = new Student();
                student.setFirstName(row[0]);
                student.setLastName(row[1]);
                student.setEnrollment_No(Long.parseLong(row[2]));
                student.setSem(Short.parseShort(row[3]));
                student.setAge(Short.parseShort(row[4]));
                studentsdata.add(student);
            }
            reader.close();
            return studentsdata;
        }catch (Exception e){
            System.out.println(e);
            return studentsdata;
        }

    }

}
