package next.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import next.dao.QuestionDao;

public class HomeController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		QuestionDao questionDao = new QuestionDao();
		System.out.println("home");
		req.setAttribute("questions", questionDao.findAll());
        return "/index.jsp";
	}
    
}
