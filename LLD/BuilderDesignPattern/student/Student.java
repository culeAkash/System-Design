package LLD.BuilderDesignPattern.student;

import java.util.List;

public class Student {

    int id;
    String name;
    int rollNo;
    int age;
    List<String> subjects;

    public  Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.rollNo = studentBuilder.rollNo;
        this.age = studentBuilder.age;
        this.subjects = studentBuilder.subjects;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", age=" + age + ", subjects=" + subjects
                + "]";
    }

    
}
