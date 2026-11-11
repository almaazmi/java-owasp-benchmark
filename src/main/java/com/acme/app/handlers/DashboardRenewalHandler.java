
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/DashboardRenewalHandler")
public class DashboardRenewalHandler extends HttpServlet {

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
        String param = scr.getTheValue("DashboardRenewalHandler");

        String bar = doSomething(request, param);

        
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + com.acme.app.support.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar;

        
        int num = 106;

        bar = (7 * 18) + num > 200 ? "the_quick_brown_fox_jumps" : param;

        return bar;
    }
}
