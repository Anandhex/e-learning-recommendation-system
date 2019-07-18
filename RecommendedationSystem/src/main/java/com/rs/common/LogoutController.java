package com.rs.common;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userData")
public class LogoutController {

	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
