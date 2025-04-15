package LLD.BuilderDesignPattern.student;

import LLD.BuilderDesignPattern.StudentType;

public class StudentFactory {
    public static StudentBuilder getStudentBuilder(StudentType studentType){
        switch (studentType){
            case ENGG:
                return new EnggStudentBuilder();
            case MBA:
                return new MBAStudentBuilder();
        }
        return null;
    }
}
