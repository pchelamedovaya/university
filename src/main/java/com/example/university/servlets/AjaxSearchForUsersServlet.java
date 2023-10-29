package com.example.university.servlets;

import com.example.university.dao.UserDAO;
import com.example.university.entity.User;
import com.example.university.utils.ConfigSingleton;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AjaxSearchForUsersServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        userDAO = (UserDAO) getServletContext().getAttribute("userDAO");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=UTF-8");
        String query = request.getParameter("query");
        List<User> users = userDAO.getUsersByPattern(query);
        JSONArray jsonArray = new JSONArray();
        for (User user : users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", user.getId());
            jsonObject.put("username", user.getUsername());
            jsonObject.put("name", user.getName());
            jsonObject.put("lastname", user.getLastname());
            jsonArray.put(jsonObject);
        }
        JSONObject object = new JSONObject();
        object.put("objects", jsonArray);

        response.setContentType("text/json");
        response.getWriter().write(object.toString());
        getServletContext().getRequestDispatcher("/WEB-INF/view/users/list.ftl");
    }
}
