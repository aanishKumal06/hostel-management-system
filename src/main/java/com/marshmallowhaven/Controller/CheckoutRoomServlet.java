package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.DeleteRoomDAO;
import com.marshmallowhaven.DAO.UpdateApplicationDAO;
import com.marshmallowhaven.DAO.UpdateRoomDAO;

/**
 * Handles room checkout process by:
 * - Validating dates
 * - Updating application checkout status and date
 * - Adjusting room occupancy and status accordingly
 */
@WebServlet("/CheckoutRoomServlet")
public class CheckoutRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Processes POST request for checking out a user from a room.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract request parameters

		String appIdStr = request.getParameter("applicationId");

	    String checkOutDateStr = request.getParameter("checkOutDate");

	    String checkInDateStr = request.getParameter("checkInDate");
	    String status = "checkout";
	    
	    
	    String roomNumber = request.getParameter("roomNumber");
	    String roomType = request.getParameter("roomType");
	    String currentOccupancyStr = request.getParameter("currentOccupancy");

	    
	    try {
	    	int currentOccupancy = Integer.parseInt(currentOccupancyStr);
	        int applicationId = Integer.parseInt(appIdStr);
	        
	        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr); 
	        LocalDate checkInDate = LocalDate.parse(checkInDateStr); 
	        // Ensure check-out is after check-in
	        if (checkOutDate.isAfter(checkInDate)) {
	        	
	        	  // Determine new occupancy and status based on room type
	        	int roomOccupancy = 0 ;  
	        	String roomStatus = "vacant";
	        	
		        if (roomType.equals("Single AC") ||roomType.equals("Single Non-AC")) {
		        	 roomOccupancy = 0 ;  
		        } else if(roomType.equals("Double AC") ||roomType.equals("Double Non-AC")) {
		        	if (currentOccupancy == 2 ) {
			        	 roomOccupancy = 1 ; 
			        }else {
			        	 roomOccupancy = 0 ;  
			        	 
			        }
		        }
		        
	            java.sql.Date sqlCheckOutDate = java.sql.Date.valueOf(checkOutDate);
	            
	            // DAO operations
	            UpdateApplicationDAO appDao = new UpdateApplicationDAO();
	            
	            UpdateRoomDAO roomDao = new UpdateRoomDAO();

	            boolean isApplicationUpdated = appDao.updateApplicationCheckOut(applicationId, sqlCheckOutDate, status);

	            boolean isRoomUpdated  = roomDao.updateRoomOccupancyAndStatus(roomNumber, roomOccupancy, roomStatus);
	            
	            if (isApplicationUpdated && isRoomUpdated) {
	                request.setAttribute("infoMsg", "Update successful!");
	            } else {
	                request.setAttribute("errorMsg", "Update failed!");
	            }
	        } else {
	            request.setAttribute("errorMsg", "Check-out date must be after check-in date.");
	        }
	        
	        

           

	        request.getRequestDispatcher("/Pages/AdminPages/check-out.jsp").forward(request, response);
	    } catch (Exception e) {
	        request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
	    }
	}

}
