
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/MessageReviewServlet")
public class MessageReviewServlet extends HttpServlet {

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

        String param = request.getParameter("MessageReviewServlet");
        if (param == null) param = "";

        String bar = doSomething(request, param);

        String sql = "SELECT userid from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
        try {
            
            
            Long results =
                    com.acme.app.support.DatabaseHelper.JDBCtemplate.queryForObject(
                            sql, Long.class);
            response.getWriter().println("Your results are: " + String.valueOf(results));
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            response.getWriter()
                    .println(
                            "No results returned for query: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql));
        } catch (org.springframework.dao.DataAccessException e) {
            if (com.acme.app.support.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "blue!";
        java.util.HashMap<String, Object> map32515 = new java.util.HashMap<String, Object>();
        map32515.put("keyA-32515", "a_Value"); 
        map32515.put("keyB-32515", param); 
        map32515.put("keyC", "another_Value"); 
        bar = (String) map32515.get("keyB-32515"); 
        bar = (String) map32515.get("keyA-32515"); 

        return bar;
    }
}
