package com.beans;

import java.util.Iterator;

public class Book implements Comparable {
private int ISBN;
private String name;
private double price;
private String author;
private String publication;


public Book(int iSBN, String name, double price, String author, String publication) {
	super();
	ISBN = iSBN;
	this.name = name;
	this.price = price;
	this.author = author;
	this.publication = publication;
}

public Book() {
name="story book";
ISBN=000;
price=100d;
author="abcd";
publication="hell0";
}

public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public Book(String author, String publication) {
	super();
	this.author = author;
	this.publication = publication;
}
@Override
public String toString() {
	return "Book [ISBN=" + ISBN + ", name=" + name + ", price=" + price + "]";
}
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
	Book b=(Book)obj;
	return(this.ISBN==b.ISBN) && (this.name.equals(b.name));
	}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.length();
	}
@Override
public int compareTo(Object arg0) {
	Book b=(Book)arg0;
	
	// TODO Auto-generated method stub
	//return (int)(this.price-b.price);
return this.name.compareTo(b.name);}
}
