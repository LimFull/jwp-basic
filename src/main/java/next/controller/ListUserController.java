package next.controller;

import core.db.DataBase;
import next.dao.UserDao;
import next.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class ListUserController implements Controller {
   
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        if (!UserSessionUtils.isLogined(req.getSession())) {
            return "redirect:/users/loginForm";
        }
        UserDao userDao = new UserDao();
        req.setAttribute("users", userDao.findAll());
        //req.setAttribute("users", DataBase.findAll());
		return "/user/list.jsp";
    }
}
