package com.librarymanagement.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.EventDAO;
import com.librarymanagement.pojo.Event;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.EventValidator;

@Controller
@RequestMapping("/lms")
public class EventController {

	@Autowired
	EventValidator validator;

	@GetMapping("/viewallevents.htm")
	public ModelAndView showAllEvents(Model model, HttpServletRequest request, EventDAO eventdao) {

		ModelAndView mv = null;

		List<Event> events = eventdao.getAllEvents();
		mv = new ModelAndView("all-events", "events", events);
		return mv;
	}

	@GetMapping("/bookevent.htm")
	public ModelAndView showAddEventForm(Model model, HttpServletRequest request, Event event, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			mv = new ModelAndView("add-event", "event", event);
		}
		return mv;
	}

	@PostMapping("/bookevent.htm")
	public ModelAndView submitAddEventForm(Event event, BindingResult results, Model model, HttpServletRequest request,
			EventDAO eventdao, UserAccount user) {

		validator.validate(event, results);
		if (results.hasErrors()) {
			return new ModelAndView("add-event", "event", event);
		}

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			eventdao.createEvent(event);

			mv = new ModelAndView("show-event", "event", event);

		}
		return mv;

	}

}
