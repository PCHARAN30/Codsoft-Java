import java.util.Scanner;
import java.lang.String;
public class StudentGradeCalculator{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of subject:");
int numSub = sc.nextInt();
int totalMarks=0;
String[] subNames = new String[numSub];
for(int i=0;i<numSub;i++){
System.out.print("Enter subject "+(i+1)+" name:");
 subNames[i] = sc.next();
System.out.print("Enter marks for "+subNames[i]+" :");
int marks=sc.nextInt();
totalMarks+=marks;
}double avgMarks = (double) totalMarks/numSub;
String grade = calculateGrade(avgMarks);
System.out.print("\nTotal Marks:"+ totalMarks);
System.out.print("\nAverage Marks:"+ avgMarks);
System.out.print("\nGrade obtained:"+ grade);
sc.close();
}
public static String calculateGrade(double marks){
 if(marks>=95){
return "A";
}else if(marks>=85){
return "A+";
}else if(marks>=75){
return "B";
}else if(marks>=65){
return "B+";
}else if(marks>=55){
return "C";
}else if (marks>=45){
return "D";
}else{
return "FAILD";
}
}
}