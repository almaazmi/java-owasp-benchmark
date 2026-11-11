
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/CustomerSelectionHandler")
public class CustomerSelectionHandler extends HttpServlet {

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
        if (request.getHeader("CustomerSelectionHandler") != null) {
            param = request.getHeader("CustomerSelectionHandler");
        }

        
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        try {
            java.security.MessageDigest md =
                    java.security.MessageDigest.getInstance("SHA-512", "SUN");
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
            md.update(input);

            byte[] result = md.digest();
            java.io.File fileTarget =
                    new java.io.File(
                            new java.io.File(com.acme.app.support.Utils.TESTFILES_DIR),
                            "passwordFile.txt");
            java.io.FileWriter fw =
                    new java.io.FileWriter(fileTarget, true); 
            fw.write(
                    "hash_value="
                            + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true)
                            + "\n");
            fw.close();
            response.getWriter()
                    .println(
                            "Sensitive value '"
                                    + org.acme
                                            .esapi
                                            .ESAPI
                                            .encoder()
                                            .encodeForHTML(new String(input))
                                    + "' hashed and stored<br/>");

        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(
                    "Problem executing request");
            throw new ServletException(e);
        } catch (java.security.NoSuchProviderException e) {
            System.out.println(
                    "Problem executing request");
            throw new ServletException(e);
        }

        response.getWriter()
                .println(
                        "Request executed");
    } 

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "alsoblue";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("blue");
            valuesList.add(param);
            valuesList.add("moreblue");

            valuesList.remove(0); 

            bar = valuesList.get(1); 
        }

        return bar;
    }
}
