package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ApplicationDetailsDAO;
import com.marshmallowhaven.DAO.ApplicationStatusDAO;
import com.marshmallowhaven.Model.ApplicationDetails;

/**
 * Servlet implementation class ApplicationDetailsServlet
 */
@WebServlet("/ApplicationDetailsServlet")
/**
 * Servlet that handles the retrieval and display of application records,
 * filtered by application status (if provided).
 * Used on the admin-side application management page.
 */
public class ApplicationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Processes GET requests to fetch all applications or filter them by status.
     * Also retrieves and sets application status counts for the dashboard UI.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the selected application status from query parameters (e.g., pending, approved, rejected)
		String status = request.getParameter("applicationStatus");
		
		ApplicationDetailsDAO  applicationDetails;
		ApplicationStatusDAO applicationStatusDAO ;

		try {
			// Get application status counts
			applicationStatusDAO = new ApplicationStatusDAO();
			 HashMap<String, Integer> applicationStatusCounts = applicationStatusDAO.getApplicationStatusCounts();
		     request.setAttribute("applicationStatusCounts", applicationStatusCounts);
		     
		     
			applicationDetails = new ApplicationDetailsDAO();
			ArrayList<ApplicationDetails> applicationList;
			// Fetch all applications
			if (status == null || status.equalsIgnoreCase("all")) {
				applicationList = applicationDetails.getAllApplicationDetails();
				
	        } // Fetch applications filtered by selected status
			else {
	        	applicationList = applicationDetails.getAllApplicationDetailsByStatus(status);
	        }
			request.setAttribute("applicationList", applicationList);
			

			
	
			 request.setAttribute("selectedApplicationType", status);
		     request.getRequestDispatcher("/Pages/AdminPages/application-management.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	}



}
