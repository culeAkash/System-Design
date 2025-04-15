package LLD.BuilderDesignPattern;

import LLD.BuilderDesignPattern.student.EnggStudentBuilder;
import LLD.BuilderDesignPattern.student.MBAStudentBuilder;
import LLD.BuilderDesignPattern.student.Student;
import LLD.BuilderDesignPattern.student.StudentBuilder;
import LLD.BuilderDesignPattern.student.StudentFactory;

public class Director {
    private StudentBuilder studentBuilder;
    
    public Director(StudentType studentType) {
        this.studentBuilder =StudentFactory.getStudentBuilder(studentType);
    }

    public Student constructStudent(){
        if(studentBuilder instanceof EnggStudentBuilder){
            return createEnggStudent();
        } else if(studentBuilder instanceof MBAStudentBuilder){
            return createMBAStudent();
        }
        return null;
    }

    private Student createMBAStudent() {
        return studentBuilder.setAge(10).build();
    }

    private Student createEnggStudent() {
        return studentBuilder.setAge(20).build();
    }
}
