package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;

public class ShowController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long questionId = Long.parseLong(request.getParameter("questionId"));
		QuestionDao questionDao = new QuestionDao();
		request.setAttribute("question", questionDao.findById(questionId));
		//AnswerDao 추가
		return "/qna/show.jsp";
	}
}
