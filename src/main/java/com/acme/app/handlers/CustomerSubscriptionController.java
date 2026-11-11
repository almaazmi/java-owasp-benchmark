
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/CustomerSubscriptionController")
public class CustomerSubscriptionController extends HttpServlet {

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
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("CustomerSubscriptionController")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = new Test().doSomething(request, param);

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.util.List<java.util.Map<String, Object>> list =
                    com.acme.app.support.DatabaseHelper.JDBCtemplate.queryForList(sql);
            response.getWriter().println("Your results are: <br>");

            for (Object o : list) {
                response.getWriter()
                        .println(
                                org.owasp.esapi.ESAPI.encoder().encodeForHTML(o.toString())
                                        + "<br>");
            }
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

    private class Test {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            
            String a83916 = param; 
            StringBuilder b83916 = new StringBuilder(a83916); 
            b83916.append(" Stuff"); 
            b83916.replace(
                    b83916.length() - "Chars".length(),
                    b83916.length(),
                    "Chars"); 
            java.util.HashMap<String, Object> map83916 = new java.util.HashMap<String, Object>();
            map83916.put("key83916", b83916.toString()); 
            String c83916 = (String) map83916.get("key83916"); 
            String d83916 = c83916.substring(0, c83916.length() - 1); 
            String e83916 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d83916.getBytes()))); 
            String f83916 = e83916.split(" ")[0]; 
            com.acme.app.support.ThingInterface thing =
                    com.acme.app.support.ThingFactory.createThing();
            String g83916 = "barbarians_at_the_gate"; 
            String bar = thing.doSomething(g83916); 

            return bar;
        }
    } 
} 
