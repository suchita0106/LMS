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
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.UserDAO;
import com.librarymanagement.pojo.UserProfile;
import com.librarymanagement.validator.UserProfValidator;
import com.librarymanagement.pojo.UserAccount;

@Controller
@RequestMapping("/lms")
public class UserProfileController {

	@Autowired
	UserProfValidator validator;

	@GetMapping("/viewprofile.htm")
	public ModelAndView viewProfile(Model model, HttpServletRequest request, UserDAO userdao, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			UserProfile userprof = userdao.getUserProfile(useracc);
			mv = new ModelAndView("view-profile", "user", userprof);
		}
		return mv;
	}

	@GetMapping("/updateuser.htm")
	public ModelAndView showUpdateUserForm(Model model, HttpServletRequest request, UserDAO userdao, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			UserProfile userprof = userdao.getUserProfile(useracc);
			mv = new ModelAndView("update-profile", "userProfile", userprof);
		}
		return mv;

	}

	@PostMapping("/updateuser.htm")
	public ModelAndView submitUpdateUserForm(@ModelAttribute("userProfile") UserProfile updatedUser,
			BindingResult results, HttpServletRequest request, UserDAO userdao) {
		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		ModelAndView mv = null;

		if (useracc == null || useracc.getId() == null) {
			mv = new ModelAndView("error-page");
		} else {
			validator.validate(updatedUser, results);
			if (results.hasErrors()) {
				mv = new ModelAndView("userProfile", "update-profile", updatedUser);
			}

			UserProfile origUserProfile = userdao.getUserProfile(useracc);
			updatedUser.setId(origUserProfile.getId());

			updatedUser.setUserAccount(updatedUser.getUserAccount());
			UserProfile dbUpdatedUser = userdao.updateUserProfile(updatedUser);
			mv = new ModelAndView("view-profile", "user", dbUpdatedUser);
		}
		return mv;
	}
}
