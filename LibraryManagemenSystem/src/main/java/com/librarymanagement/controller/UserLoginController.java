package com.librarymanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.BookDao;
import com.librarymanagement.dao.UserDAO;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.UserAccValidator;

@Controller
@RequestMapping("/lms")
public class UserLoginController {

	@Autowired
	UserAccValidator validator;

	@GetMapping(value = "/userlogin.htm")
	public String showLoginForm(Model model, UserAccount user) {
		model.addAttribute("user", user);
		return "user-login";
	}

	@GetMapping(value = "/console.htm")
	public ModelAndView homeConsoleNav(@ModelAttribute("user") UserAccount user, Model model,
			HttpServletRequest request, SessionStatus status, UserDAO userdao, BookDao bookdao) {
		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			if (useracc.getRole().equals("admin"))
				return new ModelAndView("admin-console");
			else
				return new ModelAndView("student-console");
		}

		return mv;
	}

	@PostMapping(value = "/login.htm")
	public ModelAndView submitLoginForm(@ModelAttribute("user") UserAccount user, BindingResult results, Model model,
			HttpServletRequest request, SessionStatus status, UserDAO userdao, BookDao bookdao) {
		ModelAndView mv = null;

		validator.validate(user, results);
		if (results.hasErrors()) {
			return new ModelAndView("user-login", "user", user);
		}

		UserAccount useracc = userdao.getUserAccount(user.getUsername(), user.getPassword());
		status.setComplete();

		if (useracc == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("useracc", useracc);
			if (useracc.getRole().equals("admin"))
				return new ModelAndView("admin-console");
			else
				return new ModelAndView("student-console");
		}

		return mv;
	}

}
