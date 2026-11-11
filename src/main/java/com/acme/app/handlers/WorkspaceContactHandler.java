
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/WorkspaceContactHandler")
public class WorkspaceContactHandler extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("WorkspaceContactHandler");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); 
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.sql.Statement statement =
                    com.acme.app.support.DatabaseHelper.getSqlStatement();
            java.sql.ResultSet rs = statement.executeQuery(sql);
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
        java.util.HashMap<String, Object> map94015 = new java.util.HashMap<String, Object>();
        map94015.put("keyA-94015", "a_Value"); 
        map94015.put("keyB-94015", param); 
        map94015.put("keyC", "another_Value"); 
        bar = (String) map94015.get("keyB-94015"); 
        bar = (String) map94015.get("keyA-94015"); 

        return bar;
    }
}
