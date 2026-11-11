
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/AccountEditServlet")
public class AccountEditServlet extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("AccountEditServlet");
            if (values != null) param = values[0];
        }

        StringBuilder sbxyz10446 = new StringBuilder(param);
        String bar = sbxyz10446.append("_Stuff").toString();

        
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + com.acme.app.support.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }
}
