
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/DashboardSummaryResource")
public class DashboardSummaryResource extends HttpServlet {

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

        com.acme.app.support.SeparateClassRequest scr =
                new com.acme.app.support.SeparateClassRequest(request);
        String param = scr.getTheParameter("DashboardSummaryResource");
        if (param == null) param = "";

        String bar = new Test().doSomething(request, param);

        double value = java.lang.Math.random();
        String rememberMeKey = Double.toString(value).substring(2); 

        String user = "Doug";
        String fullClassName = this.getClass().getName();
        String handlerNumber =
                fullClassName.substring(
                        fullClassName.lastIndexOf('.') + 1);
        user += handlerNumber;

        String cookieName = "rememberMe" + handlerNumber;

        boolean foundUser = false;
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; !foundUser && i < cookies.length; i++) {
                javax.servlet.http.Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
                        foundUser = true;
                    }
                }
            }
        }

        if (foundUser) {
            response.getWriter().println("Welcome back: " + user + "<br/>");

        } else {
            javax.servlet.http.Cookie rememberMe =
                    new javax.servlet.http.Cookie(cookieName, rememberMeKey);
            rememberMe.setSecure(true);
            rememberMe.setHttpOnly(true);
            rememberMe.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
            rememberMe.setPath(request.getRequestURI()); 
            
            request.getSession().setAttribute(cookieName, rememberMeKey);
            response.addCookie(rememberMe);
            response.getWriter()
                    .println(
                            user
                                    + " has been remembered with cookie: "
                                    + rememberMe.getName()
                                    + " whose value is: "
                                    + rememberMe.getValue()
                                    + "<br/>");
        }
        response.getWriter().println("Request executed");
    } 

    private class Test {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            
            String a43640 = param; 
            StringBuilder b43640 = new StringBuilder(a43640); 
            b43640.append(" Stuff"); 
            b43640.replace(
                    b43640.length() - "Chars".length(),
                    b43640.length(),
                    "Chars"); 
            java.util.HashMap<String, Object> map43640 = new java.util.HashMap<String, Object>();
            map43640.put("key43640", b43640.toString()); 
            String c43640 = (String) map43640.get("key43640"); 
            String d43640 = c43640.substring(0, c43640.length() - 1); 
            String e43640 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d43640.getBytes()))); 
            String f43640 = e43640.split(" ")[0]; 
            com.acme.app.support.ThingInterface thing =
                    com.acme.app.support.ThingFactory.createThing();
            String g43640 = "barbarians_at_the_gate"; 
            String bar = thing.doSomething(g43640); 

            return bar;
        }
    } 
} 
