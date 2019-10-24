package next.controller;

import java.util.HashMap;
import java.util.Map;



public class RequestMapping {
	private static Map<String, Controller> controllers = new HashMap<String, Controller>();
	
	static {
		controllers.put("/users", new ListUserController());
		controllers.put("/users/create", new CreateUserController());
		controllers.put("/users/form", new CreateUserController());
		controllers.put("/index", new HomeController());
		controllers.put("/", new HomeController());
		controllers.put("/users/login", new LoginController());
		controllers.put("/users/loginForm", new ForwardController("/user/login.jsp"));
		controllers.put("/users/logout", new LogoutController());
		controllers.put("/users/profile", new ProfileController());
		controllers.put("/users/update", new UpdateUserController());
		controllers.put("/users/updateForm", new UpdateUserController());
		controllers.put("/qna/show", new ShowController());
		
	}
	
	public static Controller getController(String requestValue) {
		return controllers.get(requestValue);
	}

}
