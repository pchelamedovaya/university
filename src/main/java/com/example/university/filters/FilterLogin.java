package com.example.university.filters;

import com.example.university.helpers.Helper;
import com.example.university.services.UserService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FilterLogin extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        if (username == null) {
            if (req.getCookies() != null) {
                for (Cookie cookie : req.getCookies()) {
                    if (cookie.getName().equals("auth")) {
                        username = cookie.getValue();
                    }
                }
            }
            if (username == null) {
                Helper.redirect(res, req, "/auth");
            } else {
                session.setAttribute("username", username);
                chain.doFilter(req, res);
            }
        } else {
            session.setAttribute("username", username);
            chain.doFilter(req, res);
        }
    }
}
