package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.marshmallowhaven.DAO.CompliantDetailsDAO;
import com.marshmallowhaven.Model.UserComplaint;


/**
 * Servlet to fetch and display details of a specific user complaint.
 */
@WebServlet("/CompliantDetailsServelt")
public class CompliantDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Handles GET requests to fetch complaint details by ID.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String compliantId = request.getParameter("compliant_id");
        System.out.println(compliantId);
        int compliantIdInt = Integer.parseInt(compliantId);
		
		
		CompliantDetailsDAO complaintDAO ;


	        try {
	        	complaintDAO = new CompliantDetailsDAO();

			     ArrayList<UserComplaint> complaints = complaintDAO.getComplaintsById(compliantIdInt);
	
			    
	            request.setAttribute("complaints", complaints);


	            
	            request.getRequestDispatcher("/Pages/AdminPages/complaint-details.jsp").forward(request, response);

	        } catch (Exception e) {
	            request.getRequestDispatcher("/Pages/error.jsp").forward(request, response); 
	        }
	}

	

}
