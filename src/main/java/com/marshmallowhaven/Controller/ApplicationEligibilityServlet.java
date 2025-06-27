package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.ApplicationEligibilityDAO;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class ApplicationEligibilityServlet
 */
@WebServlet("/ApplicationEligibilityServlet")
/**
 * Servlet to determine if a user is eligible to apply for a room.
 * Users are ineligible if they already have an application with 'approved' or 'pending' status.
 */
public class ApplicationEligibilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 /**
     * Handles GET requests to determine if the current user is allowed to submit a new application.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 // Retrieve the current user session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

     // If user is not logged in, redirect to login page
        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }

        
        int userId = user.getUserId();
        
		String roomID = request.getParameter("roomId");
        int roomIdInt = Integer.parseInt(roomID);

        
        boolean isapplicationEligibility = true;
        ApplicationEligibilityDAO applicationEligibility;
        
        try {
			applicationEligibility = new ApplicationEligibilityDAO();
			 ArrayList<String> statuses = applicationEligibility.getApplicationStatusesByUserId(userId);

			 // If the user has a 'pending' or 'approved' application, they are not eligible
			    for (String status : statuses) {
			    	if ("approved".equalsIgnoreCase(status) || "pending".equalsIgnoreCase(status)    ) {
			    		
			    		isapplicationEligibility = false;
			            break; // Stop checking once found
			        }
			    }
		} catch (ClassNotFoundException | SQLException e) {
		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	
	
		    if (isapplicationEligibility) {
		    	// User is eligible to apply — pass roomId to the application form
		    	request.setAttribute("roomId", roomIdInt);
		    	request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);

		    }else {
		    	// User is not eligible — show an informational message
		        request.setAttribute("infoMessage", "You have already booked the room. You cannot apply again.");
		
		        request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);
		    }
    
	}
	

}
