package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Book;
import com.dao.BookDao;
import com.dao.impl.bookDAOimpl;

/**
 * Servlet implementation class FindAllBooks
 */
@WebServlet("/findallbooks")
public class FindAllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	BookDao dao=new bookDAOimpl();
	List<Book> list=dao.findAllBook();
	request.setAttribute("books", list);
	RequestDispatcher dispatcher=request.getRequestDispatcher("show_jstl.jsp");
	dispatcher.forward(request, response);
	
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
