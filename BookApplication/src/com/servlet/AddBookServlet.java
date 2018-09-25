package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.DOMConfiguration;

import com.beans.Book;
import com.dao.BookDao;
import com.dao.impl.bookDAOimpl;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addme")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	String author=request.getParameter("author");
	int isbn=Integer.parseInt(request.getParameter("isbn"));
	double price=Double.parseDouble(request.getParameter("price"));
	String name=request.getParameter("name");
	String publication=request.getParameter("publication");
	
	Book book=new Book(isbn, name, price, author, publication);
	BookDao dao=new bookDAOimpl();
	int rows=0;
	 rows=dao.addBook(book);
	
	
	PrintWriter writer=response.getWriter();
	writer.println("<html>");
	writer.println("<body>");
	
	if (rows>0)
	{
		writer.print("books inserted successfully");
	
	}
	
	else {
		
		String message="books not inserted successfully";
	request.setAttribute("mymessage", message);
	RequestDispatcher dispatcher=request.getRequestDispatcher("addbook.jsp");
		dispatcher.forward(request, response);
	}
	
	
	writer.println("</html>");
	writer.println("</body>");
	
	}

	
	
}
