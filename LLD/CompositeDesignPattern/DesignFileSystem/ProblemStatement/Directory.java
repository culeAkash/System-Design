package LLD.CompositeDesignPattern.DesignFileSystem.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<Object> objList;

    public Directory(String name) {
        this.name = name;
        this.objList = new ArrayList<>();
    }

    public void add(Object obj){
        objList.add(obj);
    }

    public void ls(){
        System.out.println("Directory name : " + name);
        for(Object obj : objList){
            if(obj instanceof File){
                File file = (File) obj;
                file.ls();
            }
            else{
                System.out.println("Inside Directory " + name);
                Directory directory = (Directory) obj;
                directory.ls();
            }
        }
    }
}
