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

import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.DAO.WishlistEligibilityDAO;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class RoomDetailsByIdServlet
 */
@WebServlet("/RoomDetailsByIdServlet")
public class RoomDetailsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
        int roomIdInt = Integer.parseInt(roomID);
      
        RoomDetailsDAO dao;
        WishlistEligibilityDAO wish;
        
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }

        int userId = user.getUserId();

        
		try {
			dao = new RoomDetailsDAO();
			wish = new WishlistEligibilityDAO();
			 ArrayList<Room> rooms;

		            rooms = dao.getARoomDetailById(roomIdInt);
		           
		            
		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object
		        
		        boolean inWishlist = wish.isInWishlist(userId, roomIdInt);


		        request.setAttribute("rooms", rooms);
		        request.setAttribute("inWishlist", inWishlist);

		        request.getRequestDispatcher("/Pages/UserPages/room-details.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {

		    request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		}
}
	

}
