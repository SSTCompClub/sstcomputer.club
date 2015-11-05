package club.sstcomputer.web.old;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jasper C. (Another Developer) <mail@another-developer.org>
 */

@SuppressWarnings("serial")
public class Contact extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("./404.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws MalformedURLException, ProtocolException, IOException {
        String name = "", email = "", message = "", response = "", inputLine, content = "";
        
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        
        while ((inputLine = bufferedReader.readLine()) != null) {
            content = content + inputLine;
        }
        bufferedReader.close();
        
        try {
            JSONObject json = new JSONObject(content);
            name = json.getString("name");
            email = json.getString("email");
            message = json.getString("message");
            response = json.getString("response");
        } catch (JSONException ex) { Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String domain = email.split("@")[1];
        //TODO: Check domain
        
        URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret=6Lcw3goTAAAAABYnns9E1fAfCBGgPWmR8M4mVerk&response=" + response + "&remoteip=" + req.getRemoteAddr());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        int responseCode = connection.getResponseCode();
        
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder data = new StringBuilder();
        
        while ((inputLine = bufferedReader.readLine()) != null) {
            data.append(inputLine);
        }
        bufferedReader.close();
        
        resp.getOutputStream().print(data.toString());
        
        storeRequest(name, email, message, req.getRemoteAddr());
    }

    private void storeRequest(String name, String email, String message, String remoteAddress) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        
        Entity entity = new Entity("Contact");
        entity.setProperty("Name", name);
        entity.setProperty("EMail", email);
        entity.setProperty("Message", new Text(message));
        entity.setProperty("Address", remoteAddress);
        
        datastoreService.put(entity);
    }
    
    private void emailRequest(String name, String email, String message, String remoteAddress) {
        //Need to be signed up for Google Apps ... preferably ... not sure if I can redirect to sstcompclub@gmail.com
    }
}