package com.marshmallowhaven.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.UpdateUserPasswordDAO;
import com.marshmallowhaven.DAO.UpdateUserProfileImage;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.util.EncryptDecrypt;

/**
 * Servlet implementation class UserUpdatePasswordServlet
 */
@WebServlet("/UserUpdatePasswordServlet")
public class UserUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	     User user = (User) session.getAttribute("currentUser");

	     if (user == null) {
	     	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	         return;
	     }

	     int userId = user.getUserId();


	     
		ArrayList<String> updatePasswordError = new ArrayList<>();
		
	    String password = request.getParameter("password");
	    String encryptPassword = EncryptDecrypt.encrypt(password);
	    
	    
	    if (password == null || password.isEmpty()) {
	    	updatePasswordError.add("Password  is required.");
		}
	    
	    if (password.length() <= 6 || !password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,}$")) {
	    	updatePasswordError.add("Password: Must be >6 characters, include a number, uppercase letter, and special symbol (e.g., #, $).");
	    }
		
	    
	    
	    if (updatePasswordError.isEmpty()) {
	 		
	 		
	 		
			try {
			   
	     		
				UpdateUserPasswordDAO updateUserPassword = new UpdateUserPasswordDAO();
				
				boolean isUpdated = updateUserPassword.updatePassword(encryptPassword, userId);
				
				  if (isUpdated) {
			        	 request.setAttribute("updateMessage", "Password successfully updated.");
			        	 request.getRequestDispatcher("/Pages/UserPages/update-Password.jsp").forward(request, response);
			            
			        } else {
			            request.setAttribute("updateError", "Update Password failed. Please try again.");
			            request.getRequestDispatcher("/Pages/UserPages/update-password.jsp").forward(request, response);
			        
						
			} 
				  
			}catch (Exception e) {
		         request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
			}
			
			
			
	 		
			}
			
			
	 	else {
	 		request.setAttribute("updateError", "Update Password failed. Please try again.");
            request.getRequestDispatcher("/Pages/UserPages/update-password.jsp").forward(request, response);
	 		
	 	}
			
	}

}
