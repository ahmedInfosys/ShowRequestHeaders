import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowRequestHeaders")
public class ShowRequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Servlet Example: Showing Request Headers";
		out.println("<html><head><title>" + title + "</title></head>"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=CENTER>" + title
				+ "</H1>\n" + "<B>Request Method: </B>" + request.getMethod()
				+ "<BR>\n" + "<B>Request URI: </B>" + request.getRequestURI()
				+ "<BR>\n" + "<B>Request Protocol: </B>"
				+ request.getProtocol() + "<BR><BR>\n"
				+ "<TABLE BORDER=1 ALIGN=CENTER>\n"
				+ "<TR BGCOLOR=\"#FFAD00\">\n"
				+ "<TH>Header Name<TH>Header Value");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println("<TR><TD>" + headerName);
			out.println("    <TD>" + request.getHeader(headerName));
		}
		// Read from request
	    StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();
		
		out.println("<TR><TD>Request Variables:</TD><TD>" + data + "</TD></TR>");
		out.println("</TABLE>\n");
		out.println("</BODY></HTML>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
