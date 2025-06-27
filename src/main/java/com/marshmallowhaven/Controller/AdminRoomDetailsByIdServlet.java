package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.Model.Room;

/**
 * Servlet implementation class AdminRoomDetailsByIdServlet
 */
@WebServlet("/AdminRoomDetailsByIdServlet")
/**
 * Servlet responsible for retrieving room details by room ID for admin view.
 */
public class AdminRoomDetailsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Handles GET requests to fetch and display details of a specific room based on the provided room ID.
     * Expects a query parameter "roomId".
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");

        int roomIdInt = Integer.parseInt(roomID);
      
        RoomDetailsDAO dao;

        
		try {
			// Initialize the DAO and fetch room details by ID
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		            rooms = dao.getARoomDetailById(roomIdInt);
		           
		         // Construct image path base URL and pass it along with room data
		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object

		        request.setAttribute("rooms", rooms);

		        request.getRequestDispatcher("/Pages/AdminPages/room-details.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {

		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	}

	

}
