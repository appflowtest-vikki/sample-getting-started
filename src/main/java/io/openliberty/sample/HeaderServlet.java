package io.openliberty.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "HeaderServlet", urlPatterns = "/headers/*")
public class HeaderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

     response.setContentType("text/html");  
      PrintWriter out = response.getWriter();  
        
      out.println("Vikki HTTP headers sent by your client:<br>");  
        
        Enumeration<String> e = request.getHeaderNames();  
        while (e.hasMoreElements()) {  
        String headerName = (String) e.nextElement();  
        String headerValue = request.getHeader(headerName);  
        out.print("<b>"+headerName + "</b>: ");  
        out.println(headerValue + "<br>");  
      }  

    }
}
