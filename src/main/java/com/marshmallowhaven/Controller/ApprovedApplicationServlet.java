package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.UpdateApplicationDAO;


/**
 * Servlet to handle the approval of applications by updating their status in the database.
 * Triggered via a POST request from the admin panel.
 */
@WebServlet("/ApprovedApplicationServlet")
public class ApprovedApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Handles POST request to update the status of an application to 'approved'.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Retrieve application ID from the request
		String applicationIdStr = request.getParameter("application_id");
		String status = "approved";
	


		

		 try {
			 int applicationId = Integer.parseInt(applicationIdStr);
		     // Update application status using DAO
	            UpdateApplicationDAO appDao = new UpdateApplicationDAO();

	            boolean isApplicationUpdated = appDao.updateApplicationStatus(applicationId, status);

	            // Set feedback message for UI
	            if (isApplicationUpdated) {
	                request.setAttribute("infoMsg", "Update successful!");
	            } else {
	                request.setAttribute("errorMsg", "Update failed!");
	            }
		        
		        request.getRequestDispatcher("/Pages/AdminPages/application-management.jsp").forward(request, response);
		    } catch (Exception e) {
		        request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		    }

	}

}
