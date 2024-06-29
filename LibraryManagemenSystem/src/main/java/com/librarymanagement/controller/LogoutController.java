package com.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/lms")
public class LogoutController {

	@GetMapping("/logout.htm")
	public ModelAndView logout(HttpServletRequest req) {
		try {
			req.getSession().invalidate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index");

	}

}
