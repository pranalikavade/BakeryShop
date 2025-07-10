package com.bakery.model;

public class Product {

	public double price;
	public String name;
	public int id;
	public int stock;
public String toString()
{
	return id+","+name+"-"+price+"(Stock:"+stock+")";
}
}
