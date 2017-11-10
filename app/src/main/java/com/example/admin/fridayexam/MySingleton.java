package com.example.admin.fridayexam;

/**
 * Created by Admin on 11/10/2017.
 */

public class MySingleton {
    private static MySingleton instance;

    private MySingleton(){}

    public static synchronized MySingleton getInstance()
    {
        if (instance == null)
        {
            instance = new MySingleton();
        }
        return instance;
    }
}
