package com.kostandov.geekbrains.homework20.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonInfoServlet", urlPatterns = "/taskoneresult.html")
public class PersonInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String patronymic = req.getParameter("patronymic");
        String birthday = req.getParameter("birthday");
        String city = req.getParameter("city");

        try {
            writer.println("<table border=\"1\">");
            writer.println("<tr><th>Name</th><th>"+firstName+" "+secondName+" "+patronymic+"</th></tr>");
            writer.println("<tr><td>Birthday</td><td>"+city+"</td></tr>");
            writer.println("<tr><th>City</th><th>"+birthday+"</th></tr>");
            writer.println("</table>");
        } finally {
            writer.close();
        }
    }


}
