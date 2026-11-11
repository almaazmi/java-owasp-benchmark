
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/VenueSearchHandler")
public class VenueSearchHandler extends HttpServlet {

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

        String queryString = request.getQueryString();
        String paramval = "VenueSearchHandler" + "=";
        int paramLoc = -1;
        if (queryString != null) paramLoc = queryString.indexOf(paramval);
        if (paramLoc == -1) {
            response.getWriter()
                    .println(
                            "getQueryString() couldn't find expected parameter '"
                                    + "VenueSearchHandler"
                                    + "' in query string.");
            return;
        }

        String param =
                queryString.substring(
                        paramLoc
                                + paramval
                                        .length()); 
        
        
        
        int ampersandLoc = queryString.indexOf("&", paramLoc);
        if (ampersandLoc != -1) {
            param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
        }
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String sql = "{call " + bar + "}";

        try {
            java.sql.Connection connection =
                    com.acme.app.support.DatabaseHelper.getSqlConnection();
            java.sql.CallableStatement statement = connection.prepareCall(sql);
            java.sql.ResultSet rs = statement.executeQuery();
            com.acme.app.support.DatabaseHelper.printResults(rs, sql, response);

        } catch (java.sql.SQLException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "blue!";
        java.util.HashMap<String, Object> map82391 = new java.util.HashMap<String, Object>();
        map82391.put("keyA-82391", "a-Value"); 
        map82391.put("keyB-82391", param); 
        map82391.put("keyC", "another-Value"); 
        bar = (String) map82391.get("keyB-82391"); 

        return bar;
    }
}
