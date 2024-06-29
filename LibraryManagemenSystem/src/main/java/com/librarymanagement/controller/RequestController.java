package com.librarymanagement.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.BookDao;
import com.librarymanagement.dao.RequestDAO;
import com.librarymanagement.pojo.Request;
import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.RequestValidator;

@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	RequestValidator validator;

	@PostMapping(value = "/myrequest.htm")
	public ModelAndView bookRequestSubmit(HttpServletRequest request, @ModelAttribute("bookRequest") Request brequest,
			BindingResult results, RequestDAO requestDao, BookDao bookDao) throws ParseException {

		UserAccount user = (UserAccount) request.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		Date issueDate = dateFormat.parse(brequest.getIssueDate().toString());
		Date returnDate = dateFormat.parse(brequest.getReturnDate().toString());
		brequest.setIssueDate(issueDate);
		brequest.setReturnDate(returnDate);
		brequest.setUserId(user.getId());
		brequest.setUserName(user.getUsername());
		char flg = 'P';
		bookDao.updateQty(flg, brequest.getBookID());

		requestDao.save(brequest);

		return new ModelAndView("show-requests", "reqList", requestDao.getAllPendingRequests((long) user.getId()));
	}

	@GetMapping("/approvebook.htm")
	public ModelAndView allPendingRequests(HttpServletRequest req, RequestDAO brequestDao) {
		UserAccount user = (UserAccount) req.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}
		return new ModelAndView("all-booksreq", "bookReqList", brequestDao.getAllBookReuests());
	}

	@PostMapping("/processRequest.htm")
	public ModelAndView processPendingRequests(HttpServletRequest req, @RequestParam("requestId") Long id,
			@RequestParam("statusFlg") char flg, @RequestParam("bookID") Long bookID, RequestDAO brequestDao,
			BookDao bookdao) {
		UserAccount user = (UserAccount) req.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}

		int updatedCount = brequestDao.updateReq(id, flg, user.getId());
		bookdao.updateQty(flg, bookID);

		return new ModelAndView("all-booksreq", "bookReqList", brequestDao.getAllBookReuests());
	}

	@GetMapping(value = "/myreq.htm")
	public ModelAndView getRequest(HttpServletRequest request, RequestDAO requestDao) throws ParseException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}

		return new ModelAndView("show-myrequests", "reqList", requestDao.getMyBooks(user.getId()));
	}

	@GetMapping(value = "/adminreq.htm")
	public ModelAndView getAdminRequest(HttpServletRequest request, RequestDAO requestDao) throws ParseException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}

		return new ModelAndView("admin-req", "requests", requestDao.getAssignedRequests(user.getId()));
	}

}
