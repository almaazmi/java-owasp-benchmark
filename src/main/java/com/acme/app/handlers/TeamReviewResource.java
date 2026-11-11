
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/TeamReviewResource")
public class TeamReviewResource extends HttpServlet {

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

        String param = request.getParameter("TeamReviewResource");
        if (param == null) param = "";

        String bar;

        
        int num = 86;
        if ((7 * 42) - num > 200) bar = "the_quick_brown_fox_jumps";
        else bar = param;

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.sql.Statement statement =
                    com.acme.app.support.DatabaseHelper.getSqlStatement();
            statement.execute(sql, new int[] {1, 2});
            com.acme.app.support.DatabaseHelper.printResults(statement, sql, response);
        } catch (java.sql.SQLException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }
}
