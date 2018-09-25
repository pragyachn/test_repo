
package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Book;
import com.dao.*;
import com.dao.impl.*;;

/**
 * Servlet implementation class UpdateBookPrice
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		double price = Double.parseDouble(request.getParameter("price"));
		Book book = new Book();
		book.setPrice(price);
		
		BookDao dao = new bookDAOimpl();
		boolean updated = dao.updateBook(isbn, book);
		if(updated) {
			Book bk = dao.findBookbyISBN(isbn);
			List<Book> books= new ArrayList<Book>();
			books.add(bk);
			request.setAttribute("books", books);
			RequestDispatcher dispatcher = request.getRequestDispatcher("show_jstl.jsp");
			dispatcher.forward(request,	 response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("fetch");
			dispatcher.forward(request, response);
		}
				
	}

}