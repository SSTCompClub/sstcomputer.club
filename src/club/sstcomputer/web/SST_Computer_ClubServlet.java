package club.sstcomputer.web;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SST_Computer_ClubServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain"); 
		resp.getWriter().println("Hey there. You've managed to find our servlet. Well, we still yet have to add code to it to make it actually useful.");
	}	
}