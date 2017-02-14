package com.java.serialization.serialVersionUIDDemo;

import java.io.Serializable;

/**
 * Created by user on 1/26/17.
 */
public class Lion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sound;

    public Lion(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
