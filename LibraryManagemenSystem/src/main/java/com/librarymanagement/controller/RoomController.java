package com.librarymanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.RoomDAO;
import com.librarymanagement.pojo.Room;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.RoomValidator;

import java.text.ParseException;

@RestController
@RequestMapping("/lms")
public class RoomController {

	@Autowired
	RoomValidator validator;

	@GetMapping("/viewallrooms.htm")
	public ModelAndView showAllRooms(Model model, HttpServletRequest request, RoomDAO roomdao) {

		ModelAndView mv = null;

		List<Room> rooms = roomdao.getAllRooms();
		mv = new ModelAndView("all-rooms", "rooms", rooms);
		return mv;
	}

	@PostMapping("/viewallrooms.htm")
	public ModelAndView showAllRooms(HttpServletRequest request, RoomDAO roomdao,
			@RequestParam("selectedDate") String selectedDate) {
		ModelAndView mv = new ModelAndView();
		Date selectedDate1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			selectedDate1 = dateFormat.parse(selectedDate.toString());
		} catch (ParseException e) {
			System.err.println("Error parsing date: " + e.getMessage());
		}

		List<Room> rooms = roomdao.getAllRoomsByDate(selectedDate);
		mv.addObject("rooms", rooms);
		mv.setViewName("all-rooms");

		return mv;
	}

	@GetMapping("/bookroom.htm")
	public ModelAndView showBookRoomForm(Model model, HttpServletRequest request, Room room, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			mv = new ModelAndView("room-form", "room", room);
		}
		return mv;
	}

	@PostMapping("/bookroom.htm")
	public ModelAndView showAvailableRoomForm(@ModelAttribute("room") Room room, Model model,
			HttpServletRequest request, RoomDAO roomdao, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			List<Room> rooms = roomdao.getFilteredRooms();
			mv = new ModelAndView("book-room", "rooms", rooms);
		}
		return mv;

	}

	@PostMapping("/bookroomsubmit.htm")
	public ModelAndView submitBookRoomForm(@ModelAttribute("roomName") String roomName, Model model,
			HttpServletRequest request, RoomDAO roomdao, UserAccount user) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc.getId() == null) {
			mv = new ModelAndView("user-login", "user", user);
		} else {
			Room room = roomdao.getRoom(roomName);
			room.setStatus("Booked");
			roomdao.updateRoom(room);
			mv = new ModelAndView("show-room", "room", room);
		}
		return mv;

	}
}
