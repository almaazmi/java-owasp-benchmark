
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/CatalogTransferController")
public class CatalogTransferController extends HttpServlet {

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
        if (request.getHeader("CatalogTransferController") != null) {
            param = request.getHeader("CatalogTransferController");
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = "alsoblue";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("blue");
            valuesList.add(param);
            valuesList.add("moreblue");

            valuesList.remove(0); 

            bar = valuesList.get(1); 
        }

        String sql = "INSERT INTO users (username, password) VALUES ('foo','" + bar + "')";

        try {
            java.sql.Statement statement =
                    com.acme.app.support.DatabaseHelper.getSqlStatement();
            int count = statement.executeUpdate(sql, new String[] {"USERNAME", "PASSWORD"});
            com.acme.app.support.DatabaseHelper.outputUpdateComplete(sql, response);
        } catch (java.sql.SQLException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }
}
