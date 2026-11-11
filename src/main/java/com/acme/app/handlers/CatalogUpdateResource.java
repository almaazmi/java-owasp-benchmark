
















package com.acme.app.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/h/CatalogUpdateResource")
public class CatalogUpdateResource extends HttpServlet {

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

        String[] values = request.getParameterValues("CatalogUpdateResource");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test().doSomething(request, param);

        com.acme.app.support.LDAPManager ads = new com.acme.app.support.LDAPManager();
        try {
            response.setContentType("text/html;charset=UTF-8");
            javax.naming.directory.DirContext ctx = ads.getDirContext();
            String base = "ou=users,ou=system";
            javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
            sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
            String filter = "(&(objectclass=person)(uid=" + bar + "))";
            boolean found = false;
            javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results =
                    ctx.search(base, filter, sc);
            while (results.hasMore()) {
                javax.naming.directory.SearchResult sr =
                        (javax.naming.directory.SearchResult) results.next();
                javax.naming.directory.Attributes attrs = sr.getAttributes();

                javax.naming.directory.Attribute attr = attrs.get("uid");
                javax.naming.directory.Attribute attr2 = attrs.get("street");
                if (attr != null) {
                    response.getWriter()
                            .println(
                                    "LDAP query results:<br>"
                                            + "Record found with name "
                                            + org.acme
                                                    .esapi
                                                    .ESAPI
                                                    .encoder()
                                                    .encodeForHTML(attr.get().toString())
                                            + "<br>Address: "
                                            + org.acme
                                                    .esapi
                                                    .ESAPI
                                                    .encoder()
                                                    .encodeForHTML(attr2.get().toString())
                                            + "<br>");
                    found = true;
                }
            }
            if (!found) {
                response.getWriter()
                        .println(
                                "LDAP query results: nothing found for query: "
                                        + org.owasp.esapi.ESAPI.encoder().encodeForHTML(filter));
            }
        } catch (javax.naming.NamingException e) {
            throw new ServletException(e);
        } finally {
            try {
                ads.closeDirContext();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    } 

    private class Test {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            
            String a75250 = param; 
            StringBuilder b75250 = new StringBuilder(a75250); 
            b75250.append(" Stuff"); 
            b75250.replace(
                    b75250.length() - "Chars".length(),
                    b75250.length(),
                    "Chars"); 
            java.util.HashMap<String, Object> map75250 = new java.util.HashMap<String, Object>();
            map75250.put("key75250", b75250.toString()); 
            String c75250 = (String) map75250.get("key75250"); 
            String d75250 = c75250.substring(0, c75250.length() - 1); 
            String e75250 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d75250.getBytes()))); 
            String f75250 = e75250.split(" ")[0]; 
            com.acme.app.support.ThingInterface thing =
                    com.acme.app.support.ThingFactory.createThing();
            String g75250 = "barbarians_at_the_gate"; 
            String bar = thing.doSomething(g75250); 

            return bar;
        }
    } 
} 
