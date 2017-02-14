package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/2/16.
 *
 * 1)constructor can not be final.
 * 2)You cannot put additional modifiers on a final local variable.
 *
 * Check this: http://javaconceptoftheday.com/final-keyword-in-java/
 * Check this: https://www.tutorialspoint.com/java/java_variable_types.htm
 * Check this: https://docs.google.com/document/d/1_O3S7I9N7JqHYaQUQ9-yJwidoMkJaSvQcWOvnG0nT0U/edit#
 */
public class FinalTest1 {

    // Note: 'final' variable can not be initialize in static block, until we are not using 'static' keyword with it.
    // final int finalVariable; // Error:(46, 26) java: variable finalVariable have to initialize
    // static final int finalStatic1;// Error:(47, 26) java: variable finalVariable1 have to initialize
    static final int finalStatic;
    static {
        finalStatic=10;

    }
    public static void main(String[] args) {
        display();
    }



    public static void display() {
        int x =1; // default specifier
        final int y = 1; // final modifier with default specifier
        final int z;

//        Local variables can only have default specifier, final modifier and combination of both.
//        But other specifier and modifiers can not use on local variables)
//        Means following are not possible
/*
        static final int z = 2;
        public final int z = 2;
        protected final int z = 2;
        private final int z = 2;
 */

        System.out.println("In Display Method");
    }

//    Note: constructor can not be final.
//    public final FinalTest1() {}

    public FinalTest1() {}

}
