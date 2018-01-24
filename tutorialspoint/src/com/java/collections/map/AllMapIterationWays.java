package com.java.collections.map;

import java.util.*;

/**
 * Created by chetan on 8/1/18.
 */
public class AllMapIterationWays {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);


        System.out.println("\nUsing Enhanced for loop in Java 1.5");
        System.out.println("\n-----------------------------------\n");
        System.out.println( "\n1. Loop all the keys in the HashMap returned by  keySet() method \n ");
        for ( Integer key : map.keySet() )
        {
            Integer value = map.get( key );
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println( "\n2. Loop all the values in the HashMap  returned by values() method\n" );
        for ( Integer value : map.values() )
        {
            System.out.println( "value : "+value );
        }

        System.out.println( "\n3. Loop all the key/value pairs  in the HashMap  returned by entrySet() method\n " );
        for ( Map.Entry<Integer, Integer> entry : map.entrySet() )
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println("\nUsing Iterator");
        System.out.println("\n--------------\n");
        System.out.println( "\n4. Iterate all the keys  returned by keySet() method\n  ");

        Iterator<Integer> keysetIterator = map.keySet().iterator();
        while (keysetIterator.hasNext()) {
            Integer key = keysetIterator.next();
            Integer value = map.get( key );
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println( "\n5. Iterate all the key/value pairs  returned by entrySet() method\n " );

        Iterator entrysetIterator= map.entrySet().iterator();
        while (entrysetIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) entrysetIterator.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        System.out.println( "\n6. Enumerate all the keys  " );

        final Enumeration<Integer> e = Collections.enumeration(map.keySet());
        while(e.hasMoreElements())
        {      Integer key=e.nextElement();
            Integer value = map.get( key );
            System.out.println("key: " + key + ", value: " + value);
        }


        //Way 1
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(key==3) {
                iterator.remove();
                continue;
            }
            System.out.println();
        }

        //Way 2
        System.out.println("------------------------------------------------");
        System.out.println("looping HashMap in Java using EntrySet and java5 for loop");
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        //Way 3
        System.out.println("------------------------------------------------");
        System.out.println("Iterating HashMap in Java using EntrySet and Java iterator");
        Set<Map.Entry<Integer, Integer>> entrySet1 = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> entrySetIterator = entrySet1.iterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry entry = entrySetIterator.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        //Way 4
        System.out.println("------------------------------------------------");
        System.out.println("Iterating or looping map using java5 foreach loop");
        for (Integer key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
            //map.remove(key); //Exception in thread "main" java.util.ConcurrentModificationException
        }
    }

}
