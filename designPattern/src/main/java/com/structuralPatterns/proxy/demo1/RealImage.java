package main.java.com.structuralPatterns.proxy.demo1;

import java.net.URL;

/**
 * Created by Chetan Raj on 20/09/18.
 */
public class RealImage implements Image {

    public RealImage(URL url) {
        //load the image
        loadImage(url);
    }

    @Override
    public void showImage() {
        //Display the loaded image
        System.out.println("Showing the real image...");
    }

    //a method that only the real image has
    public void loadImage(URL url) {
        //complex operations to load image
        System.out.println("loading real image..." + url.toString());
    }

}
