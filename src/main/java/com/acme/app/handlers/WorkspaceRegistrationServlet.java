
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/WorkspaceRegistrationServlet")
public class WorkspaceRegistrationServlet extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("WorkspaceRegistrationServlet");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); 
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test().doSomething(request, param);

        String fileName = null;
        java.io.FileOutputStream fos = null;

        try {
            fileName = com.acme.app.support.Utils.TESTFILES_DIR + bar;

            fos = new java.io.FileOutputStream(new java.io.File(fileName), false);
            response.getWriter()
                    .println(
                            "Now ready to write to file: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));

        } catch (Exception e) {
            System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
            
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                    
                }
            }
        }
    } 

    private class Test {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;

            
            int num = 86;
            if ((7 * 42) - num > 200) bar = "the_quick_brown_fox_jumps";
            else bar = param;

            return bar;
        }
    } 
} 
