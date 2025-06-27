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
 * Servlet implementation class RoomDetailsServelt
 */
@WebServlet("/RoomDetailsServelt")
public class RoomDetailsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomType= request.getParameter("roomType"); // e.g., vacant, occupied, maintenance
		String priceRange= request.getParameter("priceRange"); 
        RoomDetailsDAO dao;
        
		try {
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		        if (roomType == null && priceRange == null ) {
		            rooms = dao.getVacantRooms();
		    

		        } else {
		            rooms = dao.getRoomsByTypeAndPriceOrder(roomType,priceRange);
		   

		        }

		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object

		        request.setAttribute("rooms", rooms);
		        request.setAttribute("selectedRoomType", roomType);
		        request.setAttribute("selectedPriceRange", priceRange);
		        request.getRequestDispatcher("/Pages/UserPages/rooms.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
	}

	

}
