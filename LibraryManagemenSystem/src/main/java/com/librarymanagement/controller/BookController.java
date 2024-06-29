package com.librarymanagement.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.dao.BookDao;
import com.librarymanagement.pojo.Book;

import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.validator.BookValidator;

@RestController
@RequestMapping(path = "/lms/books")
public class BookController {

	public BookController() {
	}

	@Autowired
	BookValidator validator;

	@PostMapping(value = "/addbook.htm")
	public ModelAndView addBook(@ModelAttribute Book book, BindingResult results, BookDao bookdao) {

		validator.validate(book, results);
		if (results.hasErrors()) {
			return new ModelAndView("admin-console");
		}

		if (book.getAuthor() == null || book.getTitle().isEmpty()) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}
		System.out.println("AUTHOR : " + book.getAuthor() + "TITLE " + book.getTitle());
		bookdao.save(book);

		return new ModelAndView("admin-console");
	}

	@PutMapping(value = "/updatebook")
	public String updateBook(@ModelAttribute Book updatedBook, BindingResult results, BookDao bookdao) {

		validator.validate(updatedBook, results);
		if (results.hasErrors()) {
			return "admin-console";
		}

		if (updatedBook.getId() == null || updatedBook == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return "errorModel";
		}
		bookdao.update(updatedBook);
		return ("success");
	}

	@GetMapping("all")
	public ModelAndView allBooks(BookDao bookdao) {
		return new ModelAndView("all-books", "bookList", bookdao.getAllBooks());
	}

	@PostMapping(value = "/bookdetails")
	public ModelAndView submitLoginForm(HttpServletRequest request, @RequestParam("bookId") Long id, BookDao bookdao) {
		ModelAndView mv = null;

		UserAccount user = (UserAccount) request.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "Book ID and updated book data are required.");
			return errorModel;
		}
		Book b = bookdao.getBookDetails(id);

		mv = new ModelAndView("book-details");
		mv.addObject("book", b);

		return mv;

	}

	@PostMapping("/searchbook.htm")
	public ModelAndView searchBooks(HttpServletRequest request,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "title", required = false) String title, @RequestParam("criteria") String criteria,
			BookDao bookDao) {

		ModelAndView mv = null;
		UserAccount user = (UserAccount) request.getSession().getAttribute("useracc");
		if (user == null) {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("message", "You must be logged in to perform this action.");
			return errorModel;
		}

		String input = null;
		if ("T".equals(criteria)) {
			if (title != null) {
				title = removeLastComma(title.trim());
				input = title;
			} else {
				ModelAndView errorModel = new ModelAndView("error");
				errorModel.addObject("message", "Title is required when searching by title.");
				return errorModel;
			}
		} else {
			if (author != null) {
				author = removeLastComma(author.trim());
				input = author;
			} else {
				ModelAndView errorModel = new ModelAndView("error");
				errorModel.addObject("message", "Author is required when searching by author.");
				return errorModel;
			}
		}

		List<Book> books = bookDao.searchByCriteria(criteria, input);
		mv = new ModelAndView("search-books", "books", books);
		return mv;
	}

	private String removeLastComma(String str) {
		if (str.endsWith(",")) {
			int lastCommaIndex = str.lastIndexOf(",");
			return str.substring(0, lastCommaIndex) + str.substring(lastCommaIndex + 1);
		}
		return str;
	}

}
