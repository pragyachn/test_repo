package com.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.connections.MyConnection;
import com.dao.BookDao;

public class bookDAOimpl implements BookDao {

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rowsAdded=0;
		String ADDBOOK="insert into book values(?,?,?,?,?)";
		Connection con=MyConnection.openConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(ADDBOOK);
	ps.setInt(1, book.getISBN());
	ps.setString(2, book.getName());
	ps.setString(3, book.getPublication());

	ps.setString(4,book.getAuthor());
	ps.setDouble(5,book.getPrice());
	rowsAdded=ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rowsAdded;
	}

	@Override
	public boolean updateBook(int ISBN, Book book) {
		
		boolean isUpdated=false;
		String Update_Book="update book set price = ? where ISBN= ?";
		try(Connection con=MyConnection.openConnection()){
			PreparedStatement ps=con.prepareStatement(Update_Book);
			ps.setInt(2, ISBN);
			ps.setDouble(1, book.getPrice());
			int rowsAdded =ps.executeUpdate();
			if(rowsAdded>0) {
				isUpdated=true;
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		// TODO Auto-generated method stub
		return isUpdated;
	}

	@Override
	public Book findBookbyISBN(int ISBN) {
		
		 Book booksearch=null;
			String FIND_BY_ISBN="select * from book where ISBN =?";
			
			
			try(Connection con =MyConnection.openConnection();) {
			
				PreparedStatement ps=con.prepareStatement(FIND_BY_ISBN);
				ps.setInt(1,ISBN);
				ResultSet set=ps.executeQuery();
				while(set.next()) {
					ISBN=set.getInt(1);
					String bookname=set.getString("BookName");
					String publication=set.getString("publication");
					String author=set.getString("author");
					double BookPrice=set.getDouble(5);
					booksearch= new Book(ISBN, bookname, BookPrice, author, publication);
		
				}
				
				
				
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				booksearch=null;
			}
			// TODO Auto-generated method stub
		return booksearch;
	}

	@Override
	public List<Book> findAllBook() {
		
		List <Book> book_list=new ArrayList <Book>();
		String FINDALL="select * from book ";
		
		
		try(Connection con =MyConnection.openConnection();) {
		
			PreparedStatement ps=con.prepareStatement(FINDALL);
		
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int ISBN=set.getInt(1);
				String bookname=set.getString("BookName");
				String publication=set.getString("publication");
				String author=set.getString("author");
				double BookPrice=set.getDouble(5);
			Book bk= new Book(ISBN, bookname, BookPrice, author, publication);
			book_list.add(bk);
			}
						
		}catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();}

		// TODO Auto-generated method stub
		return book_list;
	}

	@Override
	public List<Book> findAllBooksByPrice(double price) {
		// TODO Auto-generated method stu	return
		List <Book> book_list=new ArrayList <Book>();
		String FIND_BY_PRICE="select * from book where price =?";
		
		
		try(Connection con =MyConnection.openConnection();) {
		
			PreparedStatement ps=con.prepareStatement(FIND_BY_PRICE);
			ps.setDouble(1, price);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int ISBN=set.getInt(1);
				String bookname=set.getString("BookName");
				String publication=set.getString("publication");
				String author=set.getString("author");
				double BookPrice=set.getDouble(5);
			Book bk= new Book(ISBN, bookname, BookPrice, author, publication);
			book_list.add(bk);
			}
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();}
		
		
		
		
		// TODO Auto-generated method stub
		return book_list;
	}
public boolean DeleteBook(int ISBN) {
int set=0;
Boolean isUpdated=false;
	
String DELETE_BY_ISBN="delete from book where ISBN =?";
	
	
	try(Connection con =MyConnection.openConnection();) {
	
		PreparedStatement ps=con.prepareStatement(DELETE_BY_ISBN);
		ps.setInt(1,ISBN);
		 set=ps.executeUpdate();} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
if(set>0)
	return true;
else return isUpdated;

	
	
	
	
	

}

}
