package com.marshmallowhaven.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.DeleteNoticeDAO;

/**
 * Servlet for deleting a notice by its ID.
 */
@WebServlet("/DeleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		        String noticeIdParam = request.getParameter("noticeId");
	

		        try {
		            int noticeId = Integer.parseInt(noticeIdParam);

		            DeleteNoticeDAO dao = new DeleteNoticeDAO();
		            boolean deleted = dao.deleteNoticeAndAssociationsByNoticeId(noticeId); 
		            
		            if (deleted) {
		                request.setAttribute("message", "Notice deleted successfully.");
		            } else {
		                request.setAttribute("message", "Notice not found or could not be deleted.");
		            }

		            request.getRequestDispatcher("/Pages/AdminPages/notice-delete-message.jsp").forward(request, response);

		        } catch (Exception e) {
		            request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
		
		        }

	}

}
