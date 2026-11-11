
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/TicketTrackingResource")
public class TicketTrackingResource extends HttpServlet {

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

        String param = request.getParameter("TicketTrackingResource");
        if (param == null) param = "";

        String bar = "blue!";
        java.util.HashMap<String, Object> map86691 = new java.util.HashMap<String, Object>();
        map86691.put("keyA-86691", "a-Value"); 
        map86691.put("keyB-86691", param); 
        map86691.put("keyC", "another-Value"); 
        bar = (String) map86691.get("keyB-86691"); 

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.sql.Statement statement =
                    com.acme.app.support.DatabaseHelper.getSqlStatement();
            statement.addBatch(sql);
            int[] counts = statement.executeBatch();
            com.acme.app.support.DatabaseHelper.printResults(sql, counts, response);
        } catch (java.sql.SQLException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }
}
