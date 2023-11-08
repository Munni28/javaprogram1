package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter tm=response.getWriter();
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student"); 
			response.setContentType("text/html");
			tm.println("<html><body><table border=\"1\">");
			tm.println("<tr><th>studentid</th><th>studentname</th><th>studentmarks</th></tr>");
			while(rs.next())  {
				tm.println("<tr>");
				tm.println("<td>"+rs.getInt(1)+"</td>");
				tm.println("<td>"+rs.getString(2)+"</td>");
				tm.println("<td>"+rs.getInt(3)+"</td>");
			    tm.println("</tr>");
			}
			tm.println("</table></body></html>");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
