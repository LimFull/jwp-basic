package next.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.command.dml.ExecuteProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.dao.UserDao;
import next.model.User;


public class CreateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);
    
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	if (req.getMethod().equals("GET")) {
    		return "/user/form.jsp";
    	}else {
    		 User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
    	                req.getParameter("email"));
    	        log.debug("User : {}", user);
    	        UserDao userDao = new UserDao();
    	        try {
    	        	userDao.insert(user);
    	        } catch(SQLException e) {
    	        	log.error(e.getMessage());
    	        }
    	        DataBase.addUser(user);
    	        return "redirect:/";
    	        
    	}
    	
    }
   
}
