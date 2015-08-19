package club.sstcomputer.web;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class News extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("./404.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String request = "", inputLine, content = "";
        int page = 0;
        
        ///REMOVE///
        String HTMLEntry = "";
        ///REMOVE///
        
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        
        while ((inputLine = bufferedReader.readLine()) != null) {
            content = content + inputLine;
        }
        bufferedReader.close();
        
        try {
            JSONObject json = new JSONObject(content);
            request = json.getString("request");
            page = Integer.parseInt(json.getString("page"));
            
            ///REMOVE///
            HTMLEntry = json.getString("HtmlEntry");
            ///REMOVE///
        } catch (JSONException ex) {
            Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch (request) {
            case "get": 
                DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
                Query query = new Query("News");
                PreparedQuery preparedQuery = datastore.prepare(query);

                for (Entity result : preparedQuery.asIterable()) {
                    resp.getWriter().println(result.getProperty("Entry").toString().replaceFirst("<Text: ", "").replace(">>", ">"));
                    resp.getWriter().println("<hr>");
                }
                break;
            case "next":
                //Muhahaha, I won't do this!
                //I would like to see someone else actaully do some work on this site
                //This should be very simple to do, that is if you know the Java syntax
                break;
            case "previous":
                //Muhahaha, I won't do this!
                //I would like to see someone else actaully do some work on this site
                //This should be very simple to do, that is if you know the Java syntax
                break;
            case "addNewsToPage": 
                //This will be a week link until login authentication is added.
                //This is especially a weaklink when I am making this comment
                //and also having this website be open-source
                
                //FIXME: Add user authentication and patch this hole!
                
                DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        
                Entity entity = new Entity("News");
                entity.setProperty("Entry", new Text(HTMLEntry));

                datastoreService.put(entity);
                break;
        }
    }
}
