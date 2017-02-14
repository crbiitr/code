package com.java.immutableClassConcept;

import java.util.HashMap;

/**
 * Created by user on 1/20/17.
 */
public final class ImmutableClassDemoUsingShallowCopy {
    private final int id;
    private final String name;
    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // returning clone object instead of actual object
    public HashMap<String, String> getTestMap() {
        return testMap; // for Shallow copy
    }

    /**
     * Constructor performing Shallow copy
     * @param id
     * @param name
     * @param testMap
     */

    // comment the constructor providing deep copy and uncomment the constructor providing shallow copy.
    // Also uncomment the return statement in getTestMap() method that returns the actual object
    // reference and then execute the program once again.

    public ImmutableClassDemoUsingShallowCopy(int id, String name, HashMap<String, String> testMap) {
        System.out.println("Constructor performing Shallow copy for object initialization");
        this.id = id;
        this.name = name;
        this.testMap = testMap;
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "First");
        map.put("2", "Second");
        String s = "Original";
        int i = 10;

        ImmutableClassDemoUsingShallowCopy obj = new ImmutableClassDemoUsingShallowCopy(i,s,map);

        // Lets see whether its copy by field or reference
        System.out.println(s==obj.getName());
        System.out.println(s.equals(obj.getName()));
        System.out.println(map==obj.getTestMap());

        // Printing obj values
        System.out.println(obj.getId());
        System.out.println(obj.getName());
        System.out.println(obj.getTestMap());

        i =20;
        s = "modified";
        map.put("3", "Third");

        System.out.println("Obj id after local variable change:  " + obj.getId());
        System.out.println("Obj name after local variable change:  " + obj.getName());
        System.out.println("Obj map after local map change:  " + obj.getTestMap());

        HashMap<String, String> tempMap = obj.getTestMap();
        tempMap.put("4", "Fourth");

        System.out.println("obj testMap after changing variable from accessor method:  " + obj.getTestMap());

    }
}
