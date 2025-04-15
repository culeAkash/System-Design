package LLD.HashMapImplementation;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("A", 1);
        myHashMap.put("B", 2);
        myHashMap.put("C", 3);
        myHashMap.put("D", 4);
        myHashMap.put("E", 5);
        myHashMap.put("F", 6);
        myHashMap.put("G", 7);
        myHashMap.put("H", 8);
        myHashMap.put("I", 9);
        myHashMap.put("J", 10);
        myHashMap.put("K", 11);
        myHashMap.put("L", 12);
        myHashMap.put("M", 13);
        myHashMap.put("N", 14);
        myHashMap.put("O", 15);
        myHashMap.put("P", 16);
        myHashMap.put("Q", 17);
        myHashMap.put("R", 18);
        myHashMap.put("S", 19);

        System.out.println(myHashMap.get("A"));
        System.out.println(myHashMap.get("B"));
        System.out.println(myHashMap.get("C"));
        System.out.println(myHashMap.get("D"));
        System.out.println(myHashMap.get("E"));
        System.out.println(myHashMap.get("F"));
        System.out.println(myHashMap.get("G"));
        System.out.println(myHashMap.get("H"));
        System.out.println(myHashMap.get("I"));
        System.out.println(myHashMap.get("J"));
        System.out.println(myHashMap.get("K"));
        System.out.println(myHashMap.get("L"));
        System.out.println(myHashMap.get("M"));
        System.out.println(myHashMap.get("N"));
        System.out.println(myHashMap.get("O"));
        System.out.println(myHashMap.get("P"));
        System.out.println(myHashMap.get("Q"));
        System.out.println(myHashMap.get("R"));
        System.out.println(myHashMap.get("S"));

        System.out.println(myHashMap.size());

        myHashMap.remove("A");
        myHashMap.remove("B");
        myHashMap.remove("C");
        myHashMap.remove("D");
        myHashMap.remove("E");
        myHashMap.remove("F");
        myHashMap.remove("G");
        myHashMap.remove("H");
        myHashMap.remove("I");
        myHashMap.remove("J");
        myHashMap.remove("K");
        myHashMap.remove("L");


        System.out.println(myHashMap.size());

        
    }
}
