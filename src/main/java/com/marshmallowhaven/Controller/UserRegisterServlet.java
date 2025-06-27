package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.RegisterDAO;
import com.marshmallowhaven.DAO.UserExistsDAO;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.util.EncryptDecrypt;


/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	 	String name = request.getParameter("fullname");
	    String username = request.getParameter("username");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String retypePassword = request.getParameter("retypePassword");
	    String encryptPassword = EncryptDecrypt.encrypt(password);
	 

	    ArrayList<String> errors = new ArrayList<>();

	    if (name == null || (!name.trim().matches("^[A-Za-z]+(?: [A-Za-z]+)+$"))) {
         
            errors.add("Full name: Requires at least first and last name (letters only, separated by spaces)");
        }

	    if (username == null || username.length() <= 6 || !username.matches("^[a-zA-Z0-9]+$")) {
	        errors.add("Username must be at least 7 characters long and contain no special characters.");
	    }
	    
	    if (password == null || password.length() <= 6 || !password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,}$")) {
	        errors.add("Password: Must be >6 characters, include a number, uppercase letter, and special symbol (e.g., #, $).");
	    }
	    
	    if (!password.equals(retypePassword)) {
	        errors.add("Password and Retype Password do not match.");
	    }
	    if (gender == null || gender.trim().isEmpty()) {
	    	errors.add("gender is required.");
		}

	    
		try {
			UserExistsDAO loginDao = new UserExistsDAO();
			boolean usernameTaken = loginDao.usernameExists(username);
		    boolean emailTaken = loginDao.emailExists(email);
		    if (usernameTaken) {
		    	 errors.add("Username already exists.");
		    }
		    if (emailTaken) {
		    	errors.add("Email already exists.");
		    }

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block+
			e.printStackTrace();
		}


		if (errors.isEmpty()) {
		    try {
		        RegisterDAO registerDao = new RegisterDAO();

		        
		        User newUser = new User(
		            name,
		            email,
		            username,
		            encryptPassword, // ⚠️ Password should be hashed in production
		            gender
		        );

		        boolean isRegistered = registerDao.registerClient(newUser);

		        if (isRegistered) {
		            response.sendRedirect(request.getContextPath() +"/Pages/login.jsp");
		        } else {
		            request.setAttribute("registrationError", "Registration failed. Please try again.");
		            request.getRequestDispatcher("/Pages/register.jsp").forward(request, response);
		        }

		    } catch (ClassNotFoundException | SQLException e) {
		         request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		    }
		} else {
		    // Send error messages back to register.jsp
		    request.setAttribute("errors", errors);
		    request.getRequestDispatcher("/Pages/register.jsp").forward(request, response);
		}

		
	}
}


