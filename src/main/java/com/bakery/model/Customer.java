 package com.bakery.model;

public class Customer {
    public int id;
    public String name;
    public String phone;

    @Override
    public String toString() {
        return id + ". " + name + " (" + phone + ")";
    }
}

