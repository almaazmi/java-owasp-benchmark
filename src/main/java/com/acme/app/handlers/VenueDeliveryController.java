
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/VenueDeliveryController")
public class VenueDeliveryController extends HttpServlet {

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
        String param = scr.getTheValue("VenueDeliveryController");

        com.acme.app.support.ThingInterface thing =
                com.acme.app.support.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        String fileName = null;
        java.io.FileOutputStream fos = null;

        try {
            fileName = com.acme.app.support.Utils.TESTFILES_DIR + bar;

            fos = new java.io.FileOutputStream(new java.io.File(fileName));
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
}
