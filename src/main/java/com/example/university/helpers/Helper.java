package com.example.university.helpers;

import com.example.university.dao.UserDAO;
import com.example.university.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Helper {

    public static boolean checkVote(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        if (session.getAttribute("voted") == null) {
            session.setAttribute("voted", "true");
            return true;
        }
        return false;
    }

    public static boolean checkReg(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        if (context.getAttribute("user") == null) {
            User user = new User(
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("name"),
                    request.getParameter("lastname"),
                    request.getParameter("gender"),
                    request.getParameter("institute"),
                    request.getParameter("group"),
                    request.getParameter("about"),
                    request.getParameter("role")
            );
            context.setAttribute("user", user);
            session.setAttribute("auth", user);
            return true;
        }
        return false;
    }

    public static boolean checkCookie(HttpServletRequest request, String name) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) return true;
            }
        } catch (NullPointerException ignored) {}
        return false;
    }

    public static boolean isAuth(HttpServletRequest request, String cookieName) {
        return Helper.checkCookie(request, cookieName) || request.getSession().getAttribute("auth") != null;
    }

    public static void redirect(HttpServletResponse response, HttpServletRequest request, String path) throws IOException {
        response.sendRedirect(request.getContextPath() + path);
    }
}
