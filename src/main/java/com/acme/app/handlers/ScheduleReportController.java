
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/ScheduleReportController")
public class ScheduleReportController extends HttpServlet {

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
        String param = scr.getTheParameter("ScheduleReportController");
        if (param == null) param = "";

        String bar = "blue!";
        java.util.HashMap<String, Object> map67704 = new java.util.HashMap<String, Object>();
        map67704.put("keyA-67704", "a_Value"); 
        map67704.put("keyB-67704", param); 
        map67704.put("keyC", "another_Value"); 
        bar = (String) map67704.get("keyB-67704"); 
        bar = (String) map67704.get("keyA-67704"); 

        
        

        try {
            javax.crypto.Cipher c = com.acme.app.support.Utils.getCipher();
            
            byte[] input = {(byte) '?'};
            Object inputParam = bar;
            if (inputParam instanceof String) input = ((String) inputParam).getBytes();
            if (inputParam instanceof java.io.InputStream) {
                byte[] strInput = new byte[1000];
                int i = ((java.io.InputStream) inputParam).read(strInput);
                if (i == -1) {
                    response.getWriter()
                            .println(
                                    "This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
                    return;
                }
                input = java.util.Arrays.copyOf(strInput, i);
            }
            byte[] result = c.doFinal(input);

            java.io.File fileTarget =
                    new java.io.File(
                            new java.io.File(com.acme.app.support.Utils.TESTFILES_DIR),
                            "passwordFile.txt");
            java.io.FileWriter fw =
                    new java.io.FileWriter(fileTarget, true); 
            fw.write(
                    "secret_value="
                            + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true)
                            + "\n");
            fw.close();
            response.getWriter()
                    .println(
                            "Sensitive value: '"
                                    + org.acme
                                            .esapi
                                            .ESAPI
                                            .encoder()
                                            .encodeForHTML(new String(input))
                                    + "' encrypted and stored<br/>");

        } catch (javax.crypto.IllegalBlockSizeException e) {
            response.getWriter()
                    .println(
                            "Problem executing request");
            e.printStackTrace(response.getWriter());
            throw new ServletException(e);
        } catch (javax.crypto.BadPaddingException e) {
            response.getWriter()
                    .println(
                            "Problem executing request");
            e.printStackTrace(response.getWriter());
            throw new ServletException(e);
        }
        response.getWriter()
                .println(
                        "Request executed");
    }
}
