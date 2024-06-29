package com.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.UserDAO;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.pojo.UserProfile;
import com.librarymanagement.validator.UserAccValidator;
import com.librarymanagement.validator.UserProfValidator;

@Controller
@RequestMapping("/lms")
public class UserRegistrationController {

	@Autowired
	UserProfValidator validator;

	@GetMapping(value = "/userregister.htm")
	public String showRegistrationForm(Model model, UserProfile user) {
		model.addAttribute("user", user);
		return "user-register";
	}

	@PostMapping(value = "/userregister.htm")
	public ModelAndView submitRegistrationForm(@ModelAttribute("userProfile") UserProfile user, BindingResult results,
			Model model, SessionStatus status, UserDAO userdao) {

		ModelAndView mv = null;

		validator.validate(user, results);
		if (results.hasErrors()) {
			return new ModelAndView("user-register", "user", user);
		}

		UserAccount useracc = user.getUserAccount();

		userdao.registerUser(useracc, user);
		status.setComplete();

		mv = new ModelAndView("user-success", "user", user);
		return mv;
	}

}
