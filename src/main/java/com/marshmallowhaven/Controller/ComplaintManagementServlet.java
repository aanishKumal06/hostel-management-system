package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ComplaintTypeCountDAO;
import com.marshmallowhaven.DAO.CompliantDetailsDAO;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.UserComplaint;

/**
 * Servlet that handles viewing and filtering of user complaints
 * based on their types. Also provides complaint type counts for dashboard use.
 */
@WebServlet("/ComplaintManagementServlet")
public class ComplaintManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	/**
     * Handles GET requests for complaint management view.
     * Filters by complaint type if specified.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type= request.getParameter("ComplaintType");
		
		 // Initialize DAOs
		CompliantDetailsDAO complaintDAO ;
		ComplaintTypeCountDAO complaintTypesCountDAO;

	        try {
	        	complaintDAO = new CompliantDetailsDAO();
	        	complaintTypesCountDAO =new ComplaintTypeCountDAO();
	        	
	        	// Get complaint type summary for dashboard
	        	 HashMap<String, Integer> conmplaintsStatusCounts = complaintTypesCountDAO.getComplaintStatusCounts();
			     request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
			     
			  // Get complaint list (all or filtered)
			     ArrayList<UserComplaint> complaints;

			        if (type == null || type.equalsIgnoreCase("all")) {
			        	complaints = complaintDAO.getAllComplaintsWithUserNames();
			        }else {
			        	complaints = complaintDAO.getComplaintsByType(type);
			        }
			        

	            request.setAttribute("complaints", complaints);
	            request.setAttribute("selectedComplaint", type);
	            request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
	            
	            request.getRequestDispatcher("/Pages/AdminPages/complaint-management.jsp").forward(request, response);

	        } catch (Exception e) {
	            request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);  
	        }
		 
	}

	

}
