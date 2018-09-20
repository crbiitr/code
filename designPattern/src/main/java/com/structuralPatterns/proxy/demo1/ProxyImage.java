package main.java.com.structuralPatterns.proxy.demo1;

import java.net.URL;

/**
 * Created by B0204104 on 20/09/18.
 */
public class ProxyImage implements Image{

    private URL url;

    public ProxyImage(URL url) {
        this.url = url;
    }

    @Override
    public void showImage() {
        //show image
        RealImage realImage = new RealImage(url);
        realImage.showImage();
    }
}
