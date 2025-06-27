package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ApplicationDetailsDAO;
import com.marshmallowhaven.DAO.EmergencyContactDAO;
import com.marshmallowhaven.Model.ApplicationDetails;
import com.marshmallowhaven.Model.EmergencyContactByUserId;


@WebServlet("/ApplicationDetailsByIdServlet")
/**
 * Servlet responsible for fetching application and emergency contact details
 * for a specific user (used by admin).
 */
public class ApplicationDetailsByIdServlet extends HttpServlet {

	 /**
     * Handles GET requests to retrieve application and emergency contact info
     * based on user ID and application user ID.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationUserIdStr = request.getParameter("application_user_id");
		String userIdStr = request.getParameter("user_id");

		// Convert string parameters to integers
		int applicationUserId = Integer.parseInt(applicationUserIdStr);
		int userId = Integer.parseInt(userIdStr);
		
		ApplicationDetailsDAO  applicationDetails;
		EmergencyContactDAO emergencyContactDAO;

		try {
			// Initialize DAOs
			applicationDetails = new ApplicationDetailsDAO();
			emergencyContactDAO = new EmergencyContactDAO();

			  // Retrieve application details for the given application user ID
			ArrayList<ApplicationDetails> applicationList = applicationDetails.getAllApplicationDetailsByI(applicationUserId);
			request.setAttribute("applicationList", applicationList);
			
		      // Provide base path for displaying uploaded photos
			 ArrayList<EmergencyContactByUserId> emergencyContactList =  emergencyContactDAO.getAllEmergencyContacts(userId);
			 request.setAttribute("emergencyContactList", emergencyContactList);
			
			 String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath);
			
		
		     
		     request.getRequestDispatcher("/Pages/AdminPages/application-details.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	}



}
