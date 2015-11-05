package club.sstcomputer.web;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jasper C. (Another Developer) <mail@another-developer.org>
 */
public class Client_Interaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //Get requested path
            String pageRequest = request.getRequestURI();

            switch (pageRequest) {
                case "/500":
                case "/df":
                    response.setContentType("text/html");
                    response.getOutputStream().println(getHTMLFile(pageRequest));
                    break;
                default:
                    response.sendRedirect("./df");
                    break;
            }
        } catch (Exception ex) {
            response.setContentType("text/html");
            response.getOutputStream().println(getHTMLFile("500"));
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String inputLine, content = "";
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            while ((inputLine = bufferedReader.readLine()) != null) { content = content + inputLine; }
            bufferedReader.close();
            
            JSONObject jsonResponse = new JSONObject(content);
            String type = jsonResponse.getString("type");
            
            switch (type) {
                case "page":
                    String url[] = jsonResponse.getString("page").split("/");
                    
                    if (url[3].equals("df")) {
                        response.getOutputStream().print(getHTMLFile("home"));
                    } else if (url[3].startsWith("df?page=")) {
                        response.getOutputStream().print(getHTMLFile(url[3].replace("df?page=", "")));
                    }
                    break;
                case "validation":
                    break;
                case "news":
                    break;
                default:
                    //Block the IP
                    break;
            }
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Client_Interaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getHTMLFile(String file) {
        try {
            String inputLine, content = "";
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/html/" + file + ".html")));
            while ((inputLine = bufferedReader.readLine()) != null) { content = content + inputLine; }
            bufferedReader.close();
            
            return content;
        } catch (IOException ex) {
            if (file.equals("404")) {
                Logger.getLogger(Client_Interaction.class.getName()).log(Level.SEVERE, null, ex);
            } else {
                getHTMLFile("404");
            }
        }
        
        return "";
    }
    
    private void storeData(JSONObject object) {
        
    }
    
    private JSONObject grabData(JSONObject request) {
        JSONObject response = null;
        
        return response;
    }
}