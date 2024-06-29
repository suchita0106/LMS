package com.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.RoomDAO;
import com.librarymanagement.pojo.Room;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.RoomValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lms")
public class AdminController {

	@Autowired
	RoomValidator validator;

	@GetMapping("/adminconsole.htm")
	public ModelAndView adminConsole() {
		return new ModelAndView("admin-console");
	}

	@GetMapping("/createroom.htm")
	public ModelAndView createRoomForm(Model model, HttpServletRequest request, Room room) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc == null) {
			mv = new ModelAndView("index");
		} else {
			if ("admin".equals(useracc.getRole())) {
				mv = new ModelAndView("add-room", "room", room);
			} else {
				mv = new ModelAndView("index");
			}
		}
		return mv;

	}

	@PostMapping("/createroom.htm")
	public ModelAndView createRoom(@ModelAttribute("room") Room room, Model model, RoomDAO roomdao,
			BindingResult results) {

		roomdao.createRoom(room);

		return new ModelAndView("show-room", "room", room);

	}

	@GetMapping("/updateroom.htm")
	public ModelAndView updateRoomForm(Model model, HttpServletRequest request, RoomDAO roomdao, Room room) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc == null) {
			mv = new ModelAndView("index");
		} else {
			if ("admin".equals(useracc.getRole())) {
				mv = new ModelAndView("add-room", "room", room);
			} else {
				mv = new ModelAndView("index");
			}
		}

		return mv;

	}

	@PostMapping("/updateroom.htm")
	public ModelAndView updateRoom(Model model, RoomDAO roomdao, BindingResult results, Room room) {

		validator.validate(room, results);
		if (results.hasErrors()) {
			return new ModelAndView("add-room", "room", room);
		}

		roomdao.updateRoomAdmin(room);

		return new ModelAndView("show-room", "room", room);

	}

}
