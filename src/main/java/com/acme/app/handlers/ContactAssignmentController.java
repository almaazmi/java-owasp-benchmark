
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/ContactAssignmentController")
public class ContactAssignmentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("ContactAssignmentController");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); 
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String sql = "INSERT INTO users (username, password) VALUES ('foo','" + param + "')";

        try {
            java.sql.Statement statement =
                    com.acme.app.support.DatabaseHelper.getSqlStatement();
            int count = statement.executeUpdate(sql);
            com.acme.app.support.DatabaseHelper.outputUpdateComplete(sql, response);
        } catch (java.sql.SQLException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }
}
