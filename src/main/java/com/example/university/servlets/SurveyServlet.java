package com.example.university.servlets;

import com.example.university.helpers.Helper;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SurveyServlet extends HttpServlet {

    private static final String VOTED = "voted";

    public void init() {
        this.getServletContext().setAttribute("votes", 0);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

//        PrintWriter out = response.getWriter();
//        out.println(request.getServletContext().getAttribute("votes") + ".</p>");

        if (request.getSession().getAttribute(VOTED) == null) {
            Template template = ConfigSingleton.getConfig().getTemplate("/start/survey.ftl");
            try {
                template.process(null, response.getWriter());
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/view/start/survey.ftl").forward(request, response);
        } else {
            Helper.redirect(response, request, "/news/list");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Helper.checkVote(request);
        Helper.redirect(response, request, "/survey");
    }
}
