package com.illicitintelligence.androidexamples.util;

public class MainSingleton {

    public int getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }

    private int secretCode;

    private static MainSingleton instance = null;

    private MainSingleton() {
    }

    public static MainSingleton getInstance() {
        if(instance == null)
            instance = new MainSingleton();
        return instance;
    }
}
