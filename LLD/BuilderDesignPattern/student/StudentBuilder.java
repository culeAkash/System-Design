package LLD.BuilderDesignPattern.student;

import java.util.List;

public abstract class StudentBuilder {
    int id;
    String name;
    int rollNo;
    int age;
    List<String> subjects;


    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }


    public abstract StudentBuilder setSubjects();

    public Student build(){
        Student student = new Student(this);
        return student;
    }
}
