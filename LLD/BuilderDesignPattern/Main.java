package LLD.BuilderDesignPattern;
import LLD.BuilderDesignPattern.student.Student;

public class Main {
    public static void main(String[] args) {
        Director d1 = new Director(StudentType.ENGG);
        Director d2 = new Director(StudentType.MBA);

        Student student1 = d1.constructStudent();
        Student student2 = d2.constructStudent();

        System.out.println(student1);
        System.out.println(student2);
    }
}
