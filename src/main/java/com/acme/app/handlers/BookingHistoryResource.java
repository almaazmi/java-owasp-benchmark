
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/BookingHistoryResource")
public class BookingHistoryResource extends HttpServlet {

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

        String[] values = request.getParameterValues("BookingHistoryResource");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = "alsoblue";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("blue");
            valuesList.add(param);
            valuesList.add("moreblue");

            valuesList.remove(0); 

            bar = valuesList.get(1); 
        }

        
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + com.acme.app.support.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }
}
