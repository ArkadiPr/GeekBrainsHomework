package com.kostandov.geekbrains.homework20.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MatrixServlet", urlPatterns = "/tasktworesult.html")
public class MatrixServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(com.kostandov.geekbrains.homework20.servlets.MatrixServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        int n=0;
        try{
            n=Integer.parseInt(req.getParameter("number"));
        }catch (Exception e){
            logger.error("Incorrect input!");
            return;
        }
        try {
            writer.println("<table border=\"1\">");
            for (int i = 0; i < n; i++) {
                writer.println("<tr>");
                for (int j = 0; j < n; j++) {
                    writer.print("<th>" + (i+1) + " - " + (j+1) + " "+"</th>");
                }
                writer.print("</tr>");
            }
            writer.println("</table>");
        }finally {
            writer.close();
        }
    }
}
