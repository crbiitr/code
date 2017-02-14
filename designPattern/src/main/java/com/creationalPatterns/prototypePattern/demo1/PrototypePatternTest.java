package main.java.com.creationalPatterns.prototypePattern.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2/5/17.
 * http://www.journaldev.com/1440/prototype-design-pattern-in-java
 */

class Employee implements Cloneable {
    private List<String> empList;
    public Employee() {
        empList = new ArrayList<String>();
    }
    public Employee(List<String> list) {
        empList = list;
    }
    public List<String> getEmpList() {
        return empList;
    }
    public void loadData() {
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("Devid");
        empList.add("Liza");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> list = new ArrayList<String>();
        for (String s : this.getEmpList()) {
            list.add(s);
        }
        return new Employee(list);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String s : getEmpList()) {
            builder.append(s + ", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee();
        emp1.loadData();

        // use the clone code to get the clone object
        Employee emp2 = (Employee) emp1.clone();
        Employee emp3 = (Employee) emp1.clone();

        List<String> list1 = emp1.getEmpList();
        list1.add("Chetan");
        List<String> list2 = emp2.getEmpList();
        List<String> list3 = emp3.getEmpList();

        System.out.println("List1 after addition: " + list1.toString());
        System.out.println("List1 after addition: " + emp1.toString());
        System.out.println("List2 after addition: " + list2.toString());
        System.out.println("List3 after addition: " + list3.toString());

        list2.add("Ratan");
        list3.remove("Raj");
        System.out.println("List1 after addition and remove : " + list1.toString());
        System.out.println("List2 after addition: addition and remove " + list2.toString());
        System.out.println("List3 after addition: addition and remove " + list3.toString());

    }
}
