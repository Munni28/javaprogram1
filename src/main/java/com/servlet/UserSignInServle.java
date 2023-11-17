package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSignInServle")
public class UserSignInServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserSignInServle() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		 String username = request.getParameter("user_name");
		 String password=request.getParameter("user_password");
		 PrintWriter pw=response.getWriter();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ expense","root","root");
			PreparedStatement ps=con.prepareStatement("INSER INTO user_info(user_name,password) values(?,?)");
			ps.setString(1,username);
			ps.setString(2, password);
			int query=ps.executeUpdate();
			if(query>0) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int generatedUserId = generatedKeys.getInt(1);
                   
                        System.out.println("user_id: " + generatedUserId);
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            con.close()	;
            System.out.println("data succesfully inseted");
            if(true) {
            response.sendRedirect("http://localhost:808o/servletproject/user_registration.html");
            }
				
		 }
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	private void executeupdate() {
		// TODO Auto-generated method stub
		
	}

}
