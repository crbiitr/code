package com.java.serialization.serialVersionUIDDemo;

import java.io.*;

/**
 * Created by user on 1/26/17.
 */
public class SerialVersionUIDTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Lion leo = new Lion("Roar");

        // Serialize
        System.out.println("Serialization Done");
        FileOutputStream fos = new FileOutputStream("/tmp/serial.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(leo);

        // Deserialize
        FileInputStream fis = new FileInputStream("/tmp/serial.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Lion deserializedObj = (Lion) ois.readObject();
        System.out.println("Deserialization Done. Lion:  " + deserializedObj.getSound());

        // Note: Both objects are not same, means whenever deserialize a object,
        // it creates a new instance of that class. Which is a problem for Singleton Design pattern.
        System.out.println("Leo object hashcode:  " + leo.hashCode());
        System.out.println("deserializedObj object hashcode:  " + deserializedObj.hashCode());
    }
}
