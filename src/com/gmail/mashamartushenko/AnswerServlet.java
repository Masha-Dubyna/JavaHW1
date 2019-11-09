package com.gmail.mashamartushenko;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class AnswerServlet extends HttpServlet {

    private static AtomicInteger yes1 = new AtomicInteger(0);
    private static AtomicInteger no1 = new AtomicInteger(0);
    private static AtomicInteger yes2 = new AtomicInteger(0);
    private static AtomicInteger no2 = new AtomicInteger(0);


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ans1 = req.getParameter("q1");
        String ans2 = req.getParameter("q2");
        if (ans1 == null) ans1 = "";
        if (ans2 == null) ans2 = "";
        if (ans1.equals("yes")) {
            yes1.getAndIncrement();
        } else if(ans1.equals("no")) {
            no1.getAndIncrement();
        }

        if (ans2.equals("yes")) {
            yes2.getAndIncrement();
        } else if (ans2.equals("no")) {
            no2.getAndIncrement();
        }

        resp.getWriter().println("<html><table>" + "<tr><th></th><th>yes</th><th>no</th></tr>" +
                "<tr><td>Q1</td><td>" + yes1.get() + "</td><td>" + no1.get() + "</td></tr>" +
                "<tr><td>Q2</td><td>" + yes2.get() + "</td><td>" + no2.get() + "</td></tr>" +
                "<br><a href=\"index.html\">Get answer again</a>" + "</table></html>");
    }


}

