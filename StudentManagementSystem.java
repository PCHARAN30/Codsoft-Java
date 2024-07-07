import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int rollNumber, String grade , String course) {
        Student student = new Student(name, rollNumber, grade , course);
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                break;
            }
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: " + student.getGrade() +", Course: " + student.getCourse());
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter roll number:");
                    int rollNumber = scanner.nextInt();
                    System.out.println("Enter Grade:");
                    String grade = scanner.next();
                    System.out.println("Enter course:");
                    String course = scanner.next();
                    sms.addStudent(name, rollNumber, grade , course);
                    break;
                case 2:
                    System.out.println("Enter roll number to remove:");
                    int rollNumberToRemove = scanner.nextInt();
                    sms.removeStudent(rollNumberToRemove);
                    break;
                case 3:
                    sms.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
class Student {
    private String name;
    private int rollNum;
    private String grade;
    private String course;


    public Student(String name, int rollNumber, String grade,String course) {
        this.name = name;
        this.rollNum = rollNumber;
        this.grade = grade;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNum;
    }

    public String getGrade(){
        return grade;
    }

    public String getCourse() {
        return course;
    }
}
