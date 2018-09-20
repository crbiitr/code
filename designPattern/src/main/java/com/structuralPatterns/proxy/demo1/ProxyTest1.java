package main.java.com.structuralPatterns.proxy.demo1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Chetan Raj Bharti
 */
public class ProxyTest1 {
    public static void main(String[] args) throws MalformedURLException {
        //assuming tha the user selects a folder that has 3 images
        //create the 3 images
        Image image1 = new ProxyImage(new URL("HTTP","myDomain", 2343,"test/image1.jpg"));
        Image image2 = new ProxyImage(new URL("HTTP","myDomain", 2343,"test/image2.jpg"));
        Image image3 = new ProxyImage(new URL("HTTP","myDomain", 2343,"test/image3.jpg"));

        //assume that the user clicks on Image one item in a list
        //this would cause the program to call showImage() for that image only
        //note that this case only image one was loaded into memory
        image1.showImage();
    }
}
