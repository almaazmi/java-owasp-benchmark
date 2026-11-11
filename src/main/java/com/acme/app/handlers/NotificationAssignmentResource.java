
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/NotificationAssignmentResource")
public class NotificationAssignmentResource extends HttpServlet {

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
        String param = scr.getTheParameter("NotificationAssignmentResource");
        if (param == null) param = "";

        String bar = doSomething(request, param);

        
        request.getSession().putValue(bar, "10340");

        response.getWriter()
                .println(
                        "Item: '"
                                + com.acme.app.support.Utils.encodeForHTML(bar)
                                + "' with value: 10340 saved in session.");
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar;

        
        int num = 196;
        if ((500 / 42) + num > 200) bar = param;
        else bar = "the lazy dog sleeps late";

        return bar;
    }
}
