package LLD.CompositeDesignPattern.DesignFileSystem.ProblemStatement;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        root.add(new File("File1"));
        root.add(new File("File2"));
        Directory directory = new Directory("Directory");
        directory.add(new File("File3"));
        directory.add(new File("File4"));
        root.add(directory);
        root.ls();
    }
}
