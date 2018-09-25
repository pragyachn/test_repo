package com.dao;

import java.util.List;

import com.beans.Book;

public interface BookDao {

	int addBook (com.beans.Book book);
	boolean updateBook(int ISBN,Book book);
	Book findBookbyISBN(int ISBN);
	List <Book>findAllBook();
	List <Book>findAllBooksByPrice(double price);
	boolean DeleteBook(int ISBN);
}
