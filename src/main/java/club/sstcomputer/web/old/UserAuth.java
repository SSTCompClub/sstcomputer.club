package club.sstcomputer.web.old;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jasper C. (Another Developer) <mail@another-developer.org>
 */
public class UserAuth extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String[] requestType = request.getRequestURI().split("/");
        String queryString = request.getQueryString();
        
        switch (requestType[requestType.length].replace(queryString, "")) {
            case "login":
                //Send web page
                //Compare data in the data store
                break;
            case "register":
                //Find query string in data store to verify it as a valid request
                //Send web page
                break;
        }
        
        //Check if user is submitting an account creation forum (HTTP link query string is to be a hash of the users e-mail address) or logging in
        //Log in data is to be turned into a hash client side, sent over, and compated server side
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"text-aling: center;\">This is a temporary place holder</h1>");
            out.println("<p>Here we let the user sign into their Google account on our website, we'll get an auth code we can store and use which in turn allows us to create accounts/profiles without putting the users identity in danger.</p>");
            out.println("<p>If needed we can always encrypt data and use public and private keys if security is needed.</p>");
            out.println("<a href=\"sst-computer-club.appspot.com\">Go back home</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}