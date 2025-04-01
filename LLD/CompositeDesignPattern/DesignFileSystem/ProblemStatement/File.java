package LLD.CompositeDesignPattern.DesignFileSystem.ProblemStatement;

public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void ls(){
        System.out.println("file name : " + name);
    }
}
