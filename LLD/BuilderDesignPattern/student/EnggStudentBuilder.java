package LLD.BuilderDesignPattern.student;

public class EnggStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        this.subjects.add("Maths");
        this.subjects.add("Science");
        this.subjects.add("COA");
        return this;
    }
    
}
