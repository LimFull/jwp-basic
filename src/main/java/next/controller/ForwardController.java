package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{
	private String forwardUrl;
	
	public ForwardController(String forwardUrl) {
		this.forwardUrl = forwardUrl;
		if(forwardUrl == null) {
			throw new NullPointerException("이동할 URL을 입력하세요.");
		}
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return forwardUrl;
	}

}
