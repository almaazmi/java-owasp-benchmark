
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/MessageRegistrationResource")
public class MessageRegistrationResource extends HttpServlet {

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
        String param = scr.getTheParameter("MessageRegistrationResource");
        if (param == null) param = "";

        String bar = "blue!";
        java.util.HashMap<String, Object> map27260 = new java.util.HashMap<String, Object>();
        map27260.put("keyA-27260", "a_Value"); 
        map27260.put("keyB-27260", param); 
        map27260.put("keyC", "another_Value"); 
        bar = (String) map27260.get("keyB-27260"); 
        bar = (String) map27260.get("keyA-27260"); 

        String cmd = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            cmd = com.acme.app.support.Utils.getOSCommandString("echo");
        }

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd + bar);
            com.acme.app.support.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing request");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
