package com.marshmallowhaven.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.Model.User;

@WebFilter(urlPatterns = { "/Pages/*" })
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig filterConfig) {}
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);

        boolean isLoginRequest = uri.contains("login.jsp") || uri.contains("UserLoginServlet");
        boolean isRegisterRequest = uri.contains("register.jsp") || uri.contains("UserRegisterServlet");

        boolean isLoggedIn = session != null && session.getAttribute("currentUser") != null;
        boolean isAdminPage = isAdminPage(uri);
        boolean isCustomerPage = isCustomerPage(uri);

        if (isLoggedIn) {
            User user = (User) session.getAttribute("currentUser");
            String role = user.getRole().toLowerCase();

            // Redirect logged-in users away from login page
            if (isLoginRequest) {
                if ("admin".equals(role)) {
                    res.sendRedirect(req.getContextPath() + "/Pages/AdminPages/admin-dashboard.jsp");
                } else if ("customer".equals(role)) {
                    res.sendRedirect(req.getContextPath() + "/Pages/UserPages/home.jsp");
                }
                return;
            }

            // Admin role required
            if (isAdminPage && !"admin".equals(role)) {
                res.sendRedirect(req.getContextPath() + "/Pages/UserPages/home.jsp");
                return;
            }

            // Customer role required
            if (isCustomerPage && !"customer".equals(role)) {
                res.sendRedirect(req.getContextPath() + "/Pages/AdminPages/admin-dashboard.jsp");
                return;
            }

            // Allow access
            chain.doFilter(request, response);
        } else {
            // Not logged in: allow login and register only
            if (isLoginRequest || isRegisterRequest) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/Pages/login.jsp");
            }
        }
    }

    private boolean isAdminPage(String uri) {
        return uri.contains("/Pages/AdminPages/");
    }

    private boolean isCustomerPage(String uri) {
        return uri.contains("/Pages/UserPages/");
    }
}
