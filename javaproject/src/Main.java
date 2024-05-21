import com.studentdata.system.StudentsDataControl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    public static void main(String[] args) throws FileNotFoundException {
        StudentsDataControl s = new StudentsDataControl();
        Scanner input = new Scanner(System.in);
        System.out.println("Student Data Management System");
        while (true){
            System.out.println();
            System.out.println("1.Add Student record ");
            System.out.println("2.Search Student record");
            System.out.println("3.Display All Students");
            System.out.println("4.Update Student record");
            System.out.println("5.Delete Student record");
            System.out.println("6.Save File");
            System.out.println("7.Clear Console");
            System.out.println("8.Exit");
            System.out.print("Enter choice: ");
            String choice = input.nextLine();
            switch (choice){
                case "1":
                    s.addStudent();
                    break;
                case "2":
                    s.searchStudent();
                    break;
                case "3":
                    s.displayAllStudent();
                    break;
                case "4":
                    s.updateStudent();
                    break;
                case "5":
                    s.deleteStudent();
                    break;
                case "6":
                    s.save();
                    break;
                case "7":
                    clrscr();
                    break;
                case "8":
                    s.save();
                    return;
                default:
                    System.out.println("Worng Choice");
            }
        }
    }
}