package com.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lms")
public class WelcomeController {

	@GetMapping("/welcome.htm")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@GetMapping("/roomevent.htm")
	public ModelAndView roomevent() {
		return new ModelAndView("room-event");
	}

	@GetMapping("/student.htm")
	public ModelAndView displayStudentConsole() {
		return new ModelAndView("student-console");
	}

	@GetMapping("/admin.htm")
	public ModelAndView displayAdminConsole() {
		return new ModelAndView("admin-console");
	}

	@GetMapping("/rm.htm")
	public ModelAndView displayRoomsPage() {
		return new ModelAndView("all-rooms");
	}

	@GetMapping("/find.htm")
	public ModelAndView findBookPage() {
		return new ModelAndView("search-books");
	}

	@GetMapping("/new.htm")
	public ModelAndView addBookPage() {
		return new ModelAndView("add-book");
	}

	@GetMapping("/adminreq.htm")
	public ModelAndView adminRequestPage() {
		return new ModelAndView("admin-req");
	}

}
