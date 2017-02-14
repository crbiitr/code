package com.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 1/19/17.
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<Person> personTemp = (Class<Person>) Class.forName("com.java.reflection.Person");

        // getFields() does not return private field
        System.out.println("Fields: " + Arrays.toString(personTemp.getFields()));

        // getDeclaredFields() return both private and non private fields using reflection
        System.out.println("Declared Fields: " + Arrays.toString(personTemp.getDeclaredFields()));

        // getDeclaredMethods() return both private and non private methods using reflection
        System.out.println("Declared Methods: " + Arrays.toString(personTemp.getDeclaredMethods()));

        // getConstructors() return public constructors
        System.out.println("Public Constructor: " + Arrays.toString(personTemp.getConstructors()));

        // getConstructors() return public and private constructors
        System.out.println("Declared Constructor: " + Arrays.toString(personTemp.getDeclaredConstructors()));

        try {
            Person person = new Person("Chetan", "8095336658");

            Field privateField = personTemp.getDeclaredField("number");
            privateField.setAccessible(true);
            String value = (String) privateField.get(person);
            System.out.println("PrivateField: " + privateField + "  value: " + value);

            Method privateMethod = personTemp.getDeclaredMethod("call");
            privateMethod.setAccessible(true);
            privateMethod.invoke(person);

            Method privateMethod2 = personTemp.getDeclaredMethod("setNumber", new Class[]{String.class});
            privateMethod2.setAccessible(true);
            privateMethod2.invoke(person,"123456789");
            System.out.println(person.toString());

            // getting all constructors
            Constructor<?>[] declaredConstructors = Class.forName("com.java.reflection.Person").getDeclaredConstructors();
            System.out.println("Declared Constructor: " + Arrays.toString(declaredConstructors));

        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Person {
    public String name;
    private String number;

    public Person() {
        this.name = "DefaultName";
        this.number = "90980980";
    }

    private Person(String name) {
        this.name = "PrivateConstructorName";
        this.number = "90980980";
    }

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    private void call() {
        System.out.println("Calling " + name + " to " + number);
    }

    public String getName() {
        return name;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return "Person Class Object, Name: " + name + " and Number: " + number;
    }
}
