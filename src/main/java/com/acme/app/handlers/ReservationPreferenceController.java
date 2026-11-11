
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/ReservationPreferenceController")
public class ReservationPreferenceController extends HttpServlet {

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
        if (request.getHeader("ReservationPreferenceController") != null) {
            param = request.getHeader("ReservationPreferenceController");
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + com.acme.app.support.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = param;
        if (param != null && param.length() > 1) {
            StringBuilder sbxyz15757 = new StringBuilder(param);
            bar = sbxyz15757.replace(param.length() - "Z".length(), param.length(), "Z").toString();
        }

        return bar;
    }
}
