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
import com.marshmallowhaven.DAO.ComplaintTypeCountDAO;
import com.marshmallowhaven.DAO.RoomStatusCountDAO;
import com.marshmallowhaven.DAO.UserCountDAO;
import com.marshmallowhaven.Model.ApplicationDetails;


/**
 * Servlet implementation class AdminDashboardMangementServlet
 */
@WebServlet("/AdminDashboardMangementServlet")
/**
 * Servlet implementation class AdminDashboardMangementServlet
 * 
 * This servlet handles the retrieval of necessary data for the admin dashboard page.
 * It gathers application details, complaint stats, room status, and user counts to 
 * provide a summarized view for administrators.
 */
public class AdminDashboardMangementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * Handles the GET request to populate the admin dashboard with relevant statistics and data.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DAO instances to fetch data from the database
		ApplicationDetailsDAO  applicationDetails;
		ApplicationStatusDAO applicationStatusDAO;
		ComplaintTypeCountDAO complaintTypesCountDAO;
		RoomStatusCountDAO roomStatusCountDAO;
		UserCountDAO adminDAO ;
		try {
			// Initialize DAO objects
			applicationDetails = new ApplicationDetailsDAO();
			applicationStatusDAO = new ApplicationStatusDAO();
			complaintTypesCountDAO =new ComplaintTypeCountDAO();
			roomStatusCountDAO =  new RoomStatusCountDAO();
			adminDAO = new UserCountDAO();
			
			// Fetch top three recent applications
			ArrayList<ApplicationDetails> applicationList = applicationDetails.getTopThreeAllApplicationDetails();
			request.setAttribute("applicationList", applicationList);

			
			// Fetch application status counts (e.g., pending, approved, rejected)
			 HashMap<String, Integer> applicationStatusCounts = applicationStatusDAO.getApplicationStatusCounts();
		     request.setAttribute("applicationStatusCounts", applicationStatusCounts);
		     
	        // Fetch complaint status counts (e.g., open, resolved, in progress)
		     HashMap<String, Integer> conmplaintsStatusCounts = complaintTypesCountDAO.getComplaintStatusCounts();
		     request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
		     
		     // Fetch room status counts (e.g., available, occupied, maintenance)
		     HashMap<String, Integer> roomStatusCounts = roomStatusCountDAO.getRoomStatusCounts();
		     request.setAttribute("roomStatusCounts", roomStatusCounts);
		    
		     int totalusers = adminDAO.getTotalUserCount();
		     request.setAttribute("totalusers", totalusers);
		     
		     request.getRequestDispatcher("/Pages/AdminPages/admin-dashboard.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	    
	    }

}


