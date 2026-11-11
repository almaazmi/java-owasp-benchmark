

















package com.acme.app.support;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.reference.DefaultEncoder;







public class LDAPManager {

    private static final Encoder ESAPI_Encoder = DefaultEncoder.getInstance();
    private DirContext ctx;

    public LDAPManager() {
        try {
            ctx = getDirContext();
        } catch (NamingException e) {
            
            System.out.println("Failed to get Directory Context: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected Hashtable<Object, Object> createEnv() {
        Hashtable<Object, Object> env = new Hashtable<Object, Object>();
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        return env;
    }

    public boolean insert(LDAPPerson person) {
        Attributes matchAttrs = new BasicAttributes(true);
        matchAttrs.put(new BasicAttribute("uid", person.getName()));
        matchAttrs.put(new BasicAttribute("cn", person.getName()));
        matchAttrs.put(new BasicAttribute("street", person.getAddress()));
        matchAttrs.put(new BasicAttribute("sn", person.getName()));
        matchAttrs.put(new BasicAttribute("userpassword", person.getPassword()));
        matchAttrs.put(new BasicAttribute("objectclass", "top"));
        matchAttrs.put(new BasicAttribute("objectclass", "person"));
        matchAttrs.put(new BasicAttribute("objectclass", "organizationalPerson"));
        matchAttrs.put(new BasicAttribute("objectclass", "inetorgperson"));
        String name = "uid=" + person.getName() + ",ou=users,ou=system";
        InitialDirContext iniDirContext = (InitialDirContext) ctx;

        try {
            iniDirContext.bind(name, ctx, matchAttrs);
        } catch (NamingException e) {
            if (!e.getMessage().contains("ENTRY_ALREADY_EXISTS")) {
                System.out.println("Record already exist or an error occurred: " + e.getMessage());
            }
        }

        return true;
    }

    





    @SuppressWarnings("unused")
    private boolean search(LDAPPerson person) {
        try {

            DirContext ctx = getDirContext();
            String base = "ou=users,ou=system";

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

            String filter =
                    "(&(objectclass=person)(uid="
                            + ESAPI_Encoder.encodeForLDAP(person.getName())
                            + "))";

            NamingEnumeration<SearchResult> results = ctx.search(base, filter, sc);

            boolean foundUser = results.hasMore();

            while (results.hasMore()) {
                SearchResult sr = (SearchResult) results.next();
                Attributes attrs = sr.getAttributes();

                Attribute attr = attrs.get("uid");
                if (attr != null) {
                    
                }
            }
            ctx.close();

            return foundUser;
        } catch (Exception e) {
            System.out.println("LDAP error search: ");
            e.printStackTrace();
            return false;
        }
    }

    public DirContext getDirContext() throws NamingException {
        if (ctx == null) {
            return new InitialDirContext(createEnv());
        }
        return ctx;
    }

    public void closeDirContext() throws NamingException {
        if (ctx != null) ctx.close();
    }
}
